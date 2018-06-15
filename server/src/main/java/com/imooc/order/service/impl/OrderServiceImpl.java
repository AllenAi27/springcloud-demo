package com.imooc.order.service.impl;

import com.imooc.order.dto.OrderDto;
import com.imooc.order.enums.OrderStatus;
import com.imooc.order.enums.PayStatus;
import com.imooc.order.pojo.OrderDetail;
import com.imooc.order.pojo.OrderMaster;
import com.imooc.order.repositories.OrderDetailRepository;
import com.imooc.order.repositories.OrderMasterRepository;
import com.imooc.order.service.OrderService;
import com.imooc.order.util.BigDecimalUtil;
import com.imooc.order.util.KeyUtil;
import com.imooc.product.client.ProductClient;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;


    @Override
    public OrderDto create(OrderDto orderDto) {
        String orderId = KeyUtil.generateKey();

        //1. 查询商品(数量, 价格) 调用商品服务
        List<String> productIdList = orderDto.getOrderDetailList().stream().map(e -> e.getProductId()).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        //2. 计算总价 调用商品服务
        BigDecimal orderAmount = new BigDecimal("0");
        for(OrderDetail orderDetail : orderDto.getOrderDetailList()){
            for(ProductInfoOutput productInfo : productInfoList){
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    BigDecimal productAmount = BigDecimalUtil.mul(productInfo.getProductPrice().doubleValue(),orderDetail.getProductQuantity().doubleValue());
                    orderAmount = BigDecimalUtil.add(orderAmount.doubleValue(),productAmount.doubleValue());
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.generateKey());
                    //3. 写入订单数据库(orderDetail) 调用商品服务
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        //3. 写入订单数据库(orderMaster)
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(orderId);
        orderDto.setOrderAmount(orderAmount);
        orderDto.setOrderStatus(OrderStatus.NEW.getCode());
        orderDto.setPayStatus(PayStatus.WAIT.getCode());
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMasterRepository.save(orderMaster);

        //4. 扣库存 调用商品服务
        List<DecreaseStockInput> decreaseStockInputList = orderDto.getOrderDetailList().stream().map(e -> new DecreaseStockInput(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);
        return orderDto;
    }
}

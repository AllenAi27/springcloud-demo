package com.imooc.order.controller;

import com.imooc.order.converter.OrderForm2OrderDtoConverter;
import com.imooc.order.dto.OrderDto;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.SellException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import com.imooc.order.util.ResultVoUtil;
import com.imooc.order.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Autowired
//    private BuyerService buyerService;

    //1. 创建订单
    @PostMapping("/create")
    public ResultVo<Map<String,String>> createOrder(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("参数校验出错,orderForm:{}",orderForm);
            throw new SellException(ResultEnum.PARAMS_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDto orderDto = OrderForm2OrderDtoConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            log.error("【创建订单】,购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDto result = orderService.create(orderDto);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVoUtil.success(map);
    }

   /* //2. 订单列表
    @GetMapping("/list")
    public ResultVo<Page<OrderDto>> getOrderList(@RequestParam(value = "openid") String openid,
                                                 @RequestParam(value = "page",defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【订单列表】openid不能为空");
            throw new SellException(ResultEnum.PARAMS_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDto> orderDtoPage = orderService.findList(openid,pageRequest);
        return ResultVoUtil.success(orderDtoPage.getContent());

    }

    //3. 订单详情
    @GetMapping("/detail")
    public ResultVo<OrderDto> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
        OrderDto orderDto = buyerService.findOrderOne(openid,orderId);
        return ResultVoUtil.success(orderDto);
    }

    //4. 取消订单
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        OrderDto orderDto = buyerService.cancelOrder(openid,orderId);
        return ResultVoUtil.success();
    }*/
}

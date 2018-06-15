package com.imooc.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.order.enums.OrderStatus;
import com.imooc.order.enums.PayStatus;
import com.imooc.order.pojo.OrderDetail;
import com.imooc.order.util.EnumUtil;
import com.imooc.order.util.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    private String orderId;

    // 买家名字
    private String buyerName;

    // 买家电话
    private String buyerPhone;

    // 买家地址
    private String buyerAddress;

    // 买家微信openid
    private String buyerOpenid;

    // 订单总金额
    private BigDecimal orderAmount;

    // 订单状态 0 新下单 1 完结 2 已取消
    private Integer orderStatus;

    // 支付状态 0 未支付 1 支付成功
    private Integer payStatus;

    // 创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    // 更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatus getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatus.class);
    }

    @JsonIgnore
    public PayStatus getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatus.class);
    }
}

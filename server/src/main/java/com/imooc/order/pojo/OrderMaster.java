package com.imooc.order.pojo;

import com.imooc.order.enums.OrderStatus;
import com.imooc.order.enums.PayStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
public class OrderMaster {

    @Id
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

    // 订单状态 0 新下单
    private Integer orderStatus = OrderStatus.NEW.getCode();

    // 支付状态 0 未支付
    private Integer payStatus = PayStatus.WAIT.getCode();

    // 创建时间
    private Date createTime;

    // 更新时间
    private Date updateTime;
}
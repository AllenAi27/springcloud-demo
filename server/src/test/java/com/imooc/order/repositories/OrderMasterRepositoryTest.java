package com.imooc.order.repositories;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.enums.OrderStatus;
import com.imooc.order.enums.PayStatus;
import com.imooc.order.pojo.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{
    @Test
    public void findByBuyerOpenid() throws Exception {
    }

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("11111");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerPhone("13541204126");
        orderMaster.setBuyerOpenid("amf4875fsd23a420");
        orderMaster.setOrderAmount(new BigDecimal("100"));
        orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.WAIT.getCode());
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}
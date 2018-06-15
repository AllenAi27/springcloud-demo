package com.imooc.order.repositories;

import com.imooc.order.pojo.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest{

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("11111");
        orderDetail.setDetailId("adss2321dera");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductPrice(new BigDecimal("0.01"));
        orderDetail.setProductQuantity(2);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

}
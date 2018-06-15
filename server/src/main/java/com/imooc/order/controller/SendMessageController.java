package com.imooc.order.controller;

import com.imooc.order.dto.OrderDto;
import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

//    @RequestMapping("/sendMessage")
//    public void send(){
//        streamClient.output().send(MessageBuilder.withPayload("now " + new Date()).build());
//    }

    @RequestMapping("/sendMessage")
    public void send(){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDto).build());
    }
}

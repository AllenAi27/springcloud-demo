package com.imooc.order.converter;

import com.imooc.order.dto.OrderDto;
import com.imooc.order.pojo.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaster2OrderDtoConverter {

    public static OrderDto convert(OrderMaster orderMaster){
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster,orderDto);
        return orderDto;
    }

    public static List<OrderDto> convert(List<OrderMaster> orderMasterList){
        List<OrderDto> orderDtoList = orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
        return orderDtoList;
    }
}

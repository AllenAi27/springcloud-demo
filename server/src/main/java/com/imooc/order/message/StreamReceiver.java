package com.imooc.order.message;

import com.imooc.order.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {
//    @StreamListener(StreamClient.INPUT)
//    public void process(Object message){
//        log.info("StreamReceiver : {}", message);
//    }

//    @StreamListener(StreamClient.INPUT)
//    public void process(OrderDto orderDto){
//        log.info("StreamReceiver : {}", orderDto);
//    }
}

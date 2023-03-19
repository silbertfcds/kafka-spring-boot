package com.firmino.strconsumer.listeners;

import com.firmino.strconsumer.custom.StrConsumerListener;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.common.errors.TimeoutException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumerKafkaListener {

    @StrConsumerListener(groupId = "group-1")
    public void listenerOne(String message) {
        log.info("Listener One ::: Receive message: {}", message);
        throw new TimeoutException("Exception");
    }

//    @StrConsumerListener(groupId = "group-1")
//    public void listenerTwo(String message) {
//        log.info("Listener Two ::: Receive message: {}", message);
//    }
//
//    @StrConsumerListener(groupId = "group-2")
//    public void history(String message) {
//        log.info("history ::: Receive message: {}", message);
//    }
}

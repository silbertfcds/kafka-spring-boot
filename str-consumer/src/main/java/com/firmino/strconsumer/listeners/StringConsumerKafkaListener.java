package com.firmino.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumerKafkaListener {

    @KafkaListener(groupId = "group-1", topicPartitions = {@TopicPartition(topic = "str-topic",
            partitions = {"0"})}, containerFactory = "strContainerFactory")
    public void listenerOne(String message) {
        log.info("Listener One ::: Receive message: {}", message);
    }

    @KafkaListener(groupId = "group-1", topicPartitions = {@TopicPartition(topic = "str-topic",
            partitions = {"1"})}, containerFactory = "strContainerFactory")
    public void listenerTwo(String message) {
        log.info("Listener Two ::: Receive message: {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str", containerFactory = "strContainerFactory")
    public void history(String message) {
        log.info("history ::: Receive message: {}", message);
    }
}

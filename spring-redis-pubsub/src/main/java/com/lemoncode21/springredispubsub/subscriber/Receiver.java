package com.lemoncode21.springredispubsub.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

@Slf4j
public class Receiver implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
      log.info("Consume event {} ", message);
    }

}

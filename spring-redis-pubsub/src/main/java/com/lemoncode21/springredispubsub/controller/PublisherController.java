package com.lemoncode21.springredispubsub.controller;

import com.lemoncode21.springredispubsub.model.Customer;
import com.lemoncode21.springredispubsub.respone.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private RedisTemplate template;

    @Autowired
    private ChannelTopic channelTopic;

    @PostMapping("/customer")
    public ResponseHandler publishCustomer(@RequestBody Customer customer){
        try{
            template.convertAndSend(channelTopic.getTopic(),customer.toString());
            return  new ResponseHandler(HttpStatus.OK.toString(), "Success publish customer data!");
        }catch (Exception e){
            return  new ResponseHandler(HttpStatus.MULTI_STATUS.toString(), e.getMessage());
        }
    }
}

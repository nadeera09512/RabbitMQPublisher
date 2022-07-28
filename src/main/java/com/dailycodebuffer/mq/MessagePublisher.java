package com.dailycodebuffer.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable String content) {
    	
    	String result="Message Published";
    	
    	try {
			CustomMessage message = new CustomMessage();
			message.setMessage(content);
			message.setMessageId(UUID.randomUUID().toString());
			message.setMessageDate(new Date());
			template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
		} catch (Exception e) {
			result="error:"+e.getMessage();
		}

    	return result;
    }
}

package com.ibusiness.businessweb.messaging.consumer;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

import com.ibusiness.businessweb.dto.BusinessDto;
import com.ibusiness.businessweb.messaging.JmsConfig;

@Component
public class Consumer {
	
	
	    @JmsListener(destination = JmsConfig.TOPIC_BUSINESS_DETAILS)
	    public void consume(BusinessDto x) {
	        System.out.println("Received Back Message: " + x);
	    }
	
}
  
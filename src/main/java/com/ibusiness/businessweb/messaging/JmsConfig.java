package com.ibusiness.businessweb.messaging;

import javax.jms.Queue;

import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {
	public static final String TOPIC_BUSINESSMAN_ID = "TOPIC_BUSINESSMAN_ID";
	
	public static final String TOPIC_BUSINESS_DETAILS = "TOPIC_BUSINESS_DETAILS";

	
	    @Value("${spring.activemq.broker-url}")
	    private String brokerUrl;

	    @Bean
	    public Topic topicBusinessmanId() {

	        return new ActiveMQTopic(TOPIC_BUSINESSMAN_ID);
	    }
	    
	    @Bean
	    public Topic topicBusinessDetails() {
	        return new ActiveMQTopic(TOPIC_BUSINESS_DETAILS);
	    }

	    @Bean
	    public MessageConverter jacksonJmsMessageConverter() {
	        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	        converter.setTargetType(MessageType.TEXT);
	        converter.setTypeIdPropertyName("_type");
	        return converter;
	    }
	    
	    @Bean
	    public ActiveMQConnectionFactory activeMQConnectionFactory() {
	        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
	        factory.setBrokerURL(brokerUrl);
	        return factory;
	    }
	    
	    @Bean
	    public JmsTemplate jmsTemplate() {
	    	JmsTemplate template = new JmsTemplate();
	    	template.setConnectionFactory(activeMQConnectionFactory());
	    	template.setMessageConverter(jacksonJmsMessageConverter());
	        return template;
	    }
}

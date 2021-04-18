package com.spring.producer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.producer.amqp.AmqpProducer;
import com.spring.producer.dto.Message;
import com.spring.producer.service.AmqpService;

@Service
public class RabbitMQServiceImpl implements AmqpService{

	@Autowired
	private AmqpProducer<Message> amqp;
	
	
	@Override
	public void sendToConsumer (Message message) {
		amqp.producer(message); 
	}
}

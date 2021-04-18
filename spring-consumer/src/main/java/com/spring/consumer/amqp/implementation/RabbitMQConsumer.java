package com.spring.consumer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.consumer.amqp.AmqpConsumer;
import com.spring.consumer.dto.Message;
import com.spring.consumer.service.ConsumerService;


@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {
	
	@Autowired
	private ConsumerService consumerService;

//	Envia a mensagem para a fila
//	@Override
//	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
//	public void consumer(Message message) {
//		consumerService.action(message);
//	}
	
	
	//Envia a mensagem de erro para a deadLetter
	@Override
	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
	public void consumer(Message message) {
		try {
			consumerService.action(message);
		}catch(Exception ex){
			throw new AmqpRejectAndDontRequeueException(ex);
		}
	}
}
 
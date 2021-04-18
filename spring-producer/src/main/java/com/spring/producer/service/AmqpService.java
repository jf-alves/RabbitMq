package com.spring.producer.service;

import com.spring.producer.dto.Message;

public interface AmqpService {
	void sendToConsumer(Message message);

}

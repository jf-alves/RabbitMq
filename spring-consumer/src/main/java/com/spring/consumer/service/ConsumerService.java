package com.spring.consumer.service;

import com.spring.consumer.dto.Message;

public interface ConsumerService {

	//Consome uma mensagem da fila
	//void action(Message message);
	
	//Cria uma exception para cair na fila de erro
	void action(Message message)throws Exception;
}

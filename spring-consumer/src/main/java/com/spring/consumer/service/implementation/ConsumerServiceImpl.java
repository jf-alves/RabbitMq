package com.spring.consumer.service.implementation;

import org.springframework.stereotype.Service;

import com.spring.consumer.dto.Message;
import com.spring.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

//	//Action para enviar a messagem para a fila
	@Override
	public void action(Message message) throws Exception{
		System.out.println("Mensagem enviada com sucesso");
	}
	
//	//Action para dar erro e cair na fila deadLetter
//	@Override
//	public void action(Message message) throws Exception{
//		throw new Exception("Erro");
//	}
	
}
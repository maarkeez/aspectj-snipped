package com.aspectjsnipped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aspectjsnipped.messaging.MessageWritter;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		MessageWritter messageCommunicator = (MessageWritter) ctx.getBean("writter");
		messageCommunicator.write();
	}
}
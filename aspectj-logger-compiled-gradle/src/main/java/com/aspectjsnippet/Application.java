package com.aspectjsnippet;

import com.aspectjsnippet.messaging.MessageWritter;

public class Application {

	
	public static void main(String[] args) {
		MessageWritter messageCommunicator = new MessageWritter();
		messageCommunicator.write();
	}

}

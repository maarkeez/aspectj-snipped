package com.aspectjsnipped;

import com.aspectjsnipped.messaging.MessageWritter;

public class Main {
	public static void main(String[] args) {
		MessageWritter messageCommunicator = new MessageWritter();
		messageCommunicator.write();
		
	}
}
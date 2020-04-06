package com.aspectjsnippet;

import com.aspectjsnippet.messaging.MessageWritter;
import org.junit.jupiter.api.Test;

class ApplicationTests {

	@Test
	void testWriter () {
		MessageWritter messageCommunicator = new MessageWritter();
		messageCommunicator.write();
	}

}

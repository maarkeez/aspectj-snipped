package com.aspectjsnipped.messaging;

public class MessageWritter {
	
	public void write() {
		write("Welcome to Griffindor");
		write("Hermione", "alhomora!");
		System.out.println("Hello Hagrid");
		
		write("Welcome to Hogwarts");
		write("Harry", "wingardium leviosaaaaa..!");
		
		writeRon();
	}

	protected void write(String message) {
		System.out.println(message);
	}

	private void write(String person, String message) {
		System.out.println(person + ", " + message);
	}
	
	void writeRon() {
		write("Welcome to Slitherin");
		write("Ron", "I'm gonna die... (facepalm)");
	}
}
package com.aspectjsnipped.worker;

public class ProjectSaver {
	
	public static void backupSave() 
	{
		System.out.println("Saving backup copy in thread: " +  Thread.currentThread());
	}
}
package com.aspectjsnipped.worker;

import com.aspectjsnipped.characteristics.Slow;

@Slow
public class ProjectSaver {
	
	public static void backupSave() 
	{
		System.out.println("Saving backup copy in thread: " +  Thread.currentThread());
	}
}
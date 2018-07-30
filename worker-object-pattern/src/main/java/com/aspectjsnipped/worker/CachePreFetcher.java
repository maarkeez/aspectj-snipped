package com.aspectjsnipped.worker;

public class CachePreFetcher {
	
	public static void fetch() 
	{
		System.out.println("Fetching in thread: " +  Thread.currentThread());
	}
}
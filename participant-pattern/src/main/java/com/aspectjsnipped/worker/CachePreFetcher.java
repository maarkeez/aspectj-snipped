package com.aspectjsnipped.worker;

import com.aspectjsnipped.characteristics.Slow;

public class CachePreFetcher {
	
	@Slow
	public static void fetch() 
	{
		System.out.println("Fetching in thread: " +  Thread.currentThread());
	}
}
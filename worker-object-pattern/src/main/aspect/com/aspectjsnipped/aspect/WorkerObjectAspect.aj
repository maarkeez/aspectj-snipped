package com.aspectjsnipped.aspect;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.aspectjsnipped.worker.CachePreFetcher;
import com.aspectjsnipped.worker.ProjectSaver;

/**
 * Aspect for Worker object dessing pattern
 */
public aspect WorkerObjectAspect {
	
	/** Thread pool that execute async operations */
	private Executor executor = Executors.newCachedThreadPool();
	
	/** Select all the worker async operations to run over pool thread */
	public pointcut asyncOperation() 
		:	execution(* CachePreFetcher.fetch()) 
		||	execution(* ProjectSaver.backupSave()); 
		
	
	/** Advice to wrap the execution of any async operation and run it over the thread pool */
	void around() : asyncOperation() {
		Runnable worker = new Runnable () {
			public void run() {
				proceed();
			}
		};
		executor.execute(worker);
	}

}

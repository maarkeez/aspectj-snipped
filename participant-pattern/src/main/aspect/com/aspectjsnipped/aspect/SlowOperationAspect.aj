package com.aspectjsnipped.aspect;

public abstract aspect SlowOperationAspect {

	public abstract pointcut slowOperation();

	public static aspect SlowAnnotation extends SlowOperationAspect {
		public pointcut slowOperation() 
			:	execution(@com.aspectjsnipped.characteristics.Slow  * *(..)) 
			||	execution(* (@com.aspectjsnipped.characteristics.Slow *).*(..));
	}

	before() : slowOperation(){
		System.out.println("STARTING slow operation.");
		//... Set flag as wait for cursor. 
	}

	after() : slowOperation(){
		System.out.println("FINISHING slow operation.");
		//... Disable flag
	}
}

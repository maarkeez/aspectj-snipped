package com.aspectjsnipped.logger;

/**
 * This aspects allows to track last time a method was executed.
 */
public aspect TrackingAspect {

	/** NEW interface to be implemented by tracked classes */
	private static interface AccessTracked {
	}

	/** NEW variable to store last time */
	private long AccessTracked.lastAccessedTime;

	/** NEW method to update last time */
	public void AccessTracked.updateLastAccessedTime() {
		lastAccessedTime = System.currentTimeMillis();
	}

	/** NEW method to retrieve last time */
	public long AccessTracked.getLastAccessedTime() {
		return lastAccessedTime;
	}

	/** Hierarchy inheritance */
	declare parents: com.aspectjsnipped.messaging.MessageWritter implements AccessTracked;

	/**
	 * Bind<br>
	 * to: any AccessTracked class method.<br/>
	 * do: update last time access.<br/>
	 */
	before(AccessTracked accessTracked)
    : execution(* AccessTracked+.*(..))
      && !execution(* AccessTracked.*(..))
      && this(accessTracked) {
		accessTracked.updateLastAccessedTime();
	}

	/**
	 * Bind<br>
	 * to: any write() class method who is AcessTracked implementation.<br/>
	 * do: write last time access.<br/>
	 */
	after(AccessTracked accessTracked) : execution(* *.*..write()) && this(accessTracked){
		System.out.println("Last accessed time: " + accessTracked.getLastAccessedTime());
	}

}

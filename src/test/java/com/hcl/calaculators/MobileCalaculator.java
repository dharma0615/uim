package com.hcl.calaculators;

import org.testng.annotations.Test;

public class MobileCalaculator {
	int val1 = 10;
	int val2 = 20;

	@Test
	public void addition() {
		System.out.println("MobileCalaculator Addition: " + (this.val1 + this.val2));
	}

}

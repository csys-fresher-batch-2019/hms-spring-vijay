package com.vijaysankar.hmgsystems.randomnumber;

import java.security.SecureRandom;

public class Randomnumber {
	private static final SecureRandom rand =new SecureRandom();
	public static int getrandom() {
	int rand1 = rand.nextInt(1000000);
	return rand1;
}
}

package com.bank;

public abstract class Account {
	
	private double minimumBalance = 100;
	private static double principle=250;
	static double balance;

	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		Account.balance = balance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public static double getPrinciple() {
		return principle;
	}
	
	public static void setPrinciple(double principle) {
		Account.principle = principle;
	}

	boolean isValidTransaction(double principle,int amount) {
		double remainder=principle-amount;
		if(remainder>=minimumBalance)
			return true;
		else
			return false;	
	}
	
	double deposit(double principle, int deposit) {
		double balance=principle+deposit;
	return balance;
	}
	
	double balance(double principle) {
		return principle;
	}
	
}

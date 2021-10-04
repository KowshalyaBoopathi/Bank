package com.bank;

public abstract class Account {
	
	private double MINIMUM_BALANCE = 100;
	private static double balance=250;

	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		Account.balance = balance;
	}

	public double getMINIMUM_BALANCE() {
		return MINIMUM_BALANCE;
	}

	boolean isValidTransaction(double balance,double amount) {
		double remainder=balance-amount;
		if(remainder>=MINIMUM_BALANCE)
			return true;
		else
			return false;	
	}
	
	double deposit(double principle, int deposit) {
		double balance=principle+deposit;
	return balance;
	}
	
	abstract double balance(double principle);
		
}

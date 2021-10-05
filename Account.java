package com.bank;

public abstract class Account {
	
	private static double MINIMUM_BALANCE = 100;
	private static double balance = 250;
	private final static String number = "1234567890";

	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		Account.balance = balance;
	}

	public static double getMINIMUM_BALANCE() {
		return MINIMUM_BALANCE;
	}

	public static String getNumber() {
		return number;
	}

	/*boolean isValidTransaction(double balance,double amount) {
		double remainder=balance-amount;
		if(remainder>=MINIMUM_BALANCE)
			return true;
		else
			return false;	
	}*/
	
	abstract boolean isValidTransaction (double balance,double amount);

	boolean isValidNumber (String str,String str1) {
		if(str1.equals(str))
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

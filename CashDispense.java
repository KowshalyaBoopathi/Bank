package com.bank;

public class CashDispense extends Account {
	
	boolean dispenseCash(int amount) {
		if(amount%5==0)
			return true;
		else
			System.out.println("Please correct the amount of value. It should be multiple of USD 5"
					+ "");
		return false;
	}
	
	double chargedAmount(int amount) {
		if(amount > 100) {
			double charges=(0.04*amount);
			return charges;
		}
		else {
			double charges=(0.02*amount);
			return charges;
		}
	}
	
	double balance(double principle) {
		return principle;
	}
	
	double balance(double principle, int amount, double charges) {
		double balance=principle-amount-charges;
		return balance;	
	}
}
	
	/*boolean isValidTransaction(double balance, double minimumBalance) {
		if(balance>=minimumBalance)
			return true;
		else
			return false;	
	}*/


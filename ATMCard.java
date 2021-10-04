package com.bank;

import java.util.*;

public class ATMCard {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
		
		System.out.println("Please select an option");
		System.out.println("1 -> Deposit");
		System.out.println("2 -> Balance");
		System.out.println("3 -> Cash Withdrawal");
		System.out.println("4 -> Swipe");
		System.out.println("5 -> Cancel");
		
		int choice=sc.nextInt();
		
		switch(choice) {
		
		case 1:
			CashDispense one=new CashDispense();
			
			double principle=Account.getPrinciple();
			
			System.out.println("Deposit ");
			int deposit = sc.nextInt();
			
			principle=one.deposit(principle, deposit);
			Account.setPrinciple(principle);			
			double balance = one.balance(principle);
			principle=balance;
			Account.setBalance(principle);
			System.out.println("Balance USD "+balance);
			
			break;
		case 2:
			Account one1=new CashDispense();

			principle=Account.getPrinciple();
			balance=one1.balance(principle);
			principle=balance;
			Account.setBalance(principle);
			System.out.println("Balance USD "+balance);
			
			break;
		case 3:
			CashDispense acc=new CashDispense();
			
			principle=Account.getPrinciple();
			
			System.out.println("Enter amount");
			int amount=sc.nextInt();

			if(acc.dispenseCash(amount)) {
				double charges=acc.chargedAmount(amount);
				balance=acc.balance(principle,amount,charges);
				double minimumBalance=acc.getMinimumBalance();
				
				if(acc.isValidTransaction(balance, minimumBalance)) {
					System.out.println("Charges USD "+charges);
					principle=balance;
					Account.setPrinciple(principle);
					Account.setBalance(principle);
					System.out.println("Balance USD "+balance);	
				}
				else {
					System.out.println("Insufficient Minimum Balance");
				}			
			}
			break;
		case 4:
			SwipeShopping ss=new SwipeShopping();
			
			principle=Account.getPrinciple();
			
			System.out.println("Enter amount");
			int amount1=sc.nextInt();

			double cashback=ss.cashBack(amount1);
			System.out.println("Cashback USD "+cashback);
			balance=ss.balance(principle, amount1, cashback);
			principle=balance;
			Account.setPrinciple(principle);
			Account.setBalance(principle);
			System.out.println("Balance USD "+balance);
			break;
		case 5:
			break;
		default:
			System.out.println("Please select a valid option");	
		}
		}
	}
}










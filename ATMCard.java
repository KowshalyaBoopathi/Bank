package com.bank;

import java.util.*;

public class ATMCard {
	
	public static void main(String[] args) {
		
		double principle, balance, minimumBalance = 0;
		
		Scanner sc=new Scanner(System.in);
		
		//Create object for all cases here using down casting 
		
		Account account = new CashDispense();
		CashDispense cash=(CashDispense)account;
		
		Account account1 = new SwipeShopping();
		SwipeShopping shop=(SwipeShopping)account1;
		
		//loop to run the program continuously
		
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
			
			principle=Account.getBalance();
			
			System.out.println("Deposit ");
			int deposit = sc.nextInt();
			
			balance=cash.deposit(principle, deposit);
			Account.setBalance(balance);
			System.out.println("Balance USD "+balance);
			
			break;
		case 2:

			balance=Account.getBalance();//any class type is fine
			System.out.println("Balance USD "+balance);
			
			break;
		case 3:
	
			System.out.println("Enter your ATM card Number");
			int number=sc.nextInt();
			
			String str=Integer.toString(number);
			String str1=Account.getNumber();
			
			if(cash.isValidNumber(str,str1)) {
			
			principle=Account.getBalance();
			minimumBalance=Account.getMINIMUM_BALANCE();
			
			System.out.println("Enter amount");
			int amount=sc.nextInt();

			if(cash.dispenseCash(amount)) {
				double charges=cash.chargedAmount(amount);
				balance=cash.balance(principle,amount,charges);
				
				if(cash.isValidTransaction(balance, minimumBalance)) {
					System.out.println("Charges USD "+charges);
					Account.setBalance(balance);
					System.out.println("Balance USD "+balance);	
				}
				else 
					System.out.println("Insufficient Minimum Balance");			
			}
			}
			else
				System.out.println("Invlaid Card NUmber");
			break;
		case 4:
			
			System.out.println("Enter your ATM card Number");
			number=sc.nextInt();
			
			str=Integer.toString(number);
			str1=Account.getNumber();
			
			if(shop.isValidNumber(str,str1)) {
			
			principle=Account.getBalance();
			
			System.out.println("Enter amount");
			int amount1=sc.nextInt();

			double cashback=shop.cashBack(amount1);
			balance=shop.balance(principle, amount1, cashback);
			
			if(shop.isValidTransaction(balance, minimumBalance)) {
				System.out.println("Cashback USD "+cashback);
				Account.setBalance(balance);
				System.out.println("Balance USD "+balance);
			}
			else
				System.out.println("Insufficient Minimum Balance");	
			}
			else
				System.out.println("Invlaid Card NUmber");
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("Please select a valid option");	
		}
		}
	}
}









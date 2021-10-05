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
			Account one=new CashDispense();
			
			double principle=Account.getBalance();
			
			System.out.println("Deposit ");
			int deposit = sc.nextInt();
			
			double balance=one.deposit(principle, deposit);
			/*Account.setBalance(principle);			
			double balance = one.balance(principle);
			principle=balance;*/
			Account.setBalance(balance);
			System.out.println("Balance USD "+balance);
			
			break;
		case 2:
			/*principle=Account.getBalance();
			balance=one1.balance(principle);
			principle=balance;*/
			balance=Account.getBalance();
			System.out.println("Balance USD "+balance);
			
			break;
		case 3:
			CashDispense acc=new CashDispense();

			System.out.println("Enter your ATM card Number");
			int number=sc.nextInt();
			
			String str=Integer.toString(number);
			String str1=Account.getNumber();
			
			if(acc.isValidNumber(str,str1)) {
			
			principle=Account.getBalance();
			double minimumBalance=Account.getMINIMUM_BALANCE();
			
			System.out.println("Enter amount");
			int amount=sc.nextInt();

			if(acc.dispenseCash(amount)) {
				double charges=acc.chargedAmount(amount);
				balance=acc.balance(principle,amount,charges);
				
				if(acc.isValidTransaction(balance, minimumBalance)) {
					System.out.println("Charges USD "+charges);
					Account.setBalance(balance);
					System.out.println("Balance USD "+balance);	
				}
				else 
					System.out.println("Insufficient Minimum Balance");			
			}
			else
				System.out.println("Invlaid Card NUmber");
			}
			break;
		case 4:
			SwipeShopping ss=new SwipeShopping();
			
			System.out.println("Enter your ATM card Number");
			number=sc.nextInt();
			
			str=Integer.toString(number);
			str1=Account.getNumber();
			
			if(ss.isValidNumber(str,str1)) {
			
			principle=Account.getBalance();
			
			System.out.println("Enter amount");
			int amount1=sc.nextInt();

			double cashback=ss.cashBack(amount1);
			balance=ss.balance(principle, amount1, cashback);
			
			if(ss.isValidTransaction(principle, amount1)) {
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









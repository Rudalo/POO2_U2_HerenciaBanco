package test;

import banco.Account;
import banco.Bank;

public class Client {

public static void main(String[] args) {
		
		// Account acObj = new Account(); // Genera error, ¿por qué?
		
		// ================================================
		// TESTING ACCOUNT CLASS	
		// ================================================
	
		// -------------------------------------------------
		// Debe descomentar este bloque cuando implemente las clases
		// -------------------------------------------------
	
		Account acObj = new Account(4); 
//		
//	
		System.out.println(acObj.getBalance());
		acObj.deposit(10);
		acObj.deposit(40);
		acObj.deposit(20);
		System.out.println(acObj.getBalance());
		acObj.withdraw(20);
		System.out.println(acObj.getBalance());
		
		// ================================================
		// TESTING BANK CLASS	
		// ================================================
		
		// -------------------------------------------------
		// Debe descomentar este bloque cuando implemente las clases
		// -------------------------------------------------
		
		
		Bank bank = new Bank(); 		
		
		try {
			bank.openAccount('A', 3354678);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		try {
			bank.openAccount('C', 3354678);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		try {
			bank.openAccount('S', 10191919);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		try {
			bank.openAccount('A', 3359302);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		try {	
			bank.openAccount('C', 3379844);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		
//		
		bank.payDividend(3354678, 10);
		System.out.println(bank.getBalance(3354678));
		bank.payDividend(3354678, 30);
//		
		bank.payDividend(3359302, 50);
		bank.payDividend(3359302, 50);
//		
		bank.payDividend(3379844, 10);
		bank.payDividend(3379844, 10);
//		
		System.out.println("*** Val = "+bank.getBalance(3379844));
//		
		bank.withdrawAccount(3379844, 20);
		bank.withdrawAccount(3379844, 5);
		
//		
		System.out.println("*** Val = "+bank.getBalance(3379844));
//		
		bank.withdrawAccount(3379844, 15);
//		
		System.out.println("*** Val = "+bank.getBalance(3379844));
//		
		bank.sendLetterToOverdraftAccounts();
		
		try {
			bank.openAccount('D', 1234);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		bank.payDividend(1234, 1000);
		System.out.println(bank.getBalance(1234));
		bank.payDividend(1234, 1000);
		System.out.println(bank.getBalance(1234));
		bank.withdrawAccount(1234, 500);
		System.out.println(bank.getBalance(1234));
		bank.withdrawAccount(1234, 1020.1);
		System.out.println(bank.getBalance(1234));
		
	
		// ==================================================
	
	
		/*
		 	Debería obtener un resultado similar a este:
		 	
		 	*** Val = 20.0
			CurrentAccount.withdraw
			CurrentAccount.withdraw
			Bank.getBalance
			Bank.payDividend ::: ac.getBalance() = -5.0
			*** Val = -5.0
			CurrentAccount.withdraw
			CurrentAccount.withdraw(...): cannot withdraw this amount.
			Bank.getBalance
			Bank.payDividend ::: ac.getBalance() = -5.0
			*** Val = -5.0
			Sending letter to this 3379844 account
		 */
		
	}
	
}

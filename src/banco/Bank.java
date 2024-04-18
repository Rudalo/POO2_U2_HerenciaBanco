package banco;

import java.util.ArrayList;

public class Bank {
	ArrayList<Account> accounts;
	
	final double interest = 0.01;
	private int cont = 0;

	public Bank() {
		accounts = new ArrayList<>();
	}

	public void openAccount(char typeAcc, int numAcc)throws Exception {
		if(typeAcc != 'A' && typeAcc != 'C') {
			System.err.println("Tipo de cuenta no valida");
		}
		if(findAccount(numAcc) != null){
			System.err.println("Cuenta ya existente");
		}
		if (typeAcc == 'C') {
			Account account = new CurrentAccount(numAcc, 0);
			accounts.add(account);
		} else if (typeAcc == 'A') {
			Account account = new SavingsAccount(numAcc, 0);
			accounts.add(account);
		} else if(typeAcc == 'D') {
			Account account = new CDT(numAcc, 2);
			accounts.add(account);
		}
	}
	
	public void payDividend(int numAcc, double sum) {
		Account acc = findAccount(numAcc);
		
		try {
			if(cont == 1) {
				throw new RuntimeException("Ya se ha depositado una vez");
			}
			if(acc instanceof CDT) {
				cont++;
			}
			if(sum <= 0) {
				throw new RuntimeException("No se puede depositar un valor negativo o nulo");
			}
			if(acc == null) {
				throw new RuntimeException("No se encuentra la cuenta a la que se quiere depositar");
			}
			acc.deposit(sum);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public void withdrawAccount(int numAcc, double sum) {
		Account acc = findAccount(numAcc);
		try {
			if(sum <= 0) {
				throw new RuntimeException("No se pueden retirar valores negativos o nulos");
			}
			if(acc == null) {
				throw new RuntimeException("No se puede retirar de una cuenta no existente");
			}
			acc.withdraw(sum);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void sendLetterToOverdraftAccounts() {
		for(Account acc : accounts) {
			if(acc.getBalance() < 0) {
				System.out.println("Sending letter to this " + acc.getAccountNumber() + " account");
			}
		}
	}
	
	private Account findAccount(int numAcc) {
		for(Account acc : accounts) {
			if(acc.getAccountNumber() == numAcc) {
				return acc;
			}
		}
		return null;
	}
	
	public double getBalance(int numAcc) {
		Account acc = findAccount(numAcc);
		try {
			if(acc == null) {
				throw new RuntimeException("No se encuentra la cuenta");
			}
			return acc.getBalance();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return 0.0;
	}
	
	public double getInterest() {
		return interest;
	}
}

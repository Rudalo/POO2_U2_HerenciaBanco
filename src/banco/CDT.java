package banco;

public class CDT extends Account {

	//private double monto = 0;
	private int mes;
	
	public CDT(int a) {
		super(a);
	}
	
	public CDT(int a, int mes) {
		super(a);
		this.mes = mes;
	}
	
	@Override
	public void deposit(double sum) {
		Bank bank = new Bank();
		for(int i = 0; i < mes; i++) {
			sum += sum * bank.getInterest();
		}
		super.deposit(sum);
	}
	
	@Override
	public void withdraw(double sum) {
		if(sum != getBalance()) {
			throw new RuntimeException("Solo se puede retirar el total del balance");
		}
		super.withdraw(getBalance());
	}
	
}

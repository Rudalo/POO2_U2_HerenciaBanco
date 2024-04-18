package banco;

public class CurrentAccount extends Account{

	private double limitOverDraft;
	
	public CurrentAccount(int accnum, double limitOverDraft) {
		super(accnum);
		this.limitOverDraft = 5;
	}
	
	@Override
	public void withdraw(double sum) {
		if(sum <= getBalance() + limitOverDraft) {
			super.withdraw(sum);
		}else {
			System.err.println("Cantidad a retirar mayor que su balance en cuenta");
		}
	}

}

package banco;

public class SavingsAccount extends Account {
	
    private double interest;

    public SavingsAccount(int accnum, double interest) {
        super(accnum);
        this.interest = interest;
    }

    @Override
    public void deposit(double sum) {
        if (sum > 0) {
            double monto = (getBalance() * interest);
            double total = monto + sum;
            super.deposit(total);
        } else {
            System.err.println("Incorrect or negative value.");
        }
    }
    
    public double getInterest(double interest) {
    	return interest;
    }
}

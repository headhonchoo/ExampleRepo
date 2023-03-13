//Sidney Mcclendon (smcclendon1@csudh.edu)
public class CheckingAccount extends Account {
	private double overdraftLimit;

    public CheckingAccount(int accountNumber, String type, Person accountHolder, double overdraftLimit) {
        super(accountNumber, type, accountHolder);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) throws AccountClosedException, InsufficientBalanceException {
        if (!isOpen()) {
            throw new AccountClosedException("Account is closed. Cannot withdraw money.");
        }
        if (amount <= 0) {
           throw new IllegalArgumentException("Invalid amount. Withdrawal amount must be greater than zero."); }

     if (getBalance() - amount < -overdraftLimit) {
        throw new InsufficientBalanceException("Withdrawal amount exceeds overdraft limit.");
    }

    setBalance(getBalance() - amount);
    return true;
    }

    public double getOverdraftLimit() {
    return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
    }
}
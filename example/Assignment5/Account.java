//Sidney Mcclendon (smcclendon1@csudh.edu)
public class Account {
	//Fields
	private int accountNumber;
    private String type;
    private boolean accountOpen;
    private double balance;
    private Person accountHolder;
    
    //Constructor
    public Account(int accountNumber, String type, Person accountHolder) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.accountHolder = accountHolder;
        this.accountOpen = true;
        this.balance = 0;

    }
    
    public boolean withdraw(double amount) throws AccountClosedException, InsufficientBalanceException {
        if (!isOpen()) {
            throw new AccountClosedException("Account is closed. Cannot withdraw money.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount. Amount must be greater than zero.");
        }
        if (this.balance - amount < -getOverdraftLimit()) {
            throw new InsufficientBalanceException("Insufficient funds. Cannot withdraw money.");
        }
        this.balance -= amount;
        return true;
    }

    public boolean deposit(double amount) throws AccountClosedException {
        if (!isOpen()) {
            throw new AccountClosedException("Account is closed. Cannot deposit money.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount. Amount must be greater than zero.");
        }
        this.balance += amount;
        return true;
    }

    public boolean isOpen() {
        return this.accountOpen;
    }

    public String getType() {
        return type;
    }

    public void closeAccount() {
        this.accountOpen = false;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getOverdraftLimit() {
        return 0;
    }

    @Override
    public String toString() {
        if (accountOpen) {
            return this.accountNumber + "(" + type + ") : " + this.accountHolder.toString() + " : " + this.balance + " : Account Open";
        }
        return this.accountNumber + "(" + type + ") : " + this.accountHolder.toString() + " : " + this.balance + " : Account Closed";
    }
 }

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

    public boolean withdraw(double amount) {

        if (this.balance - amount < 0) return false;
        this.balance = this.balance - amount;
        return true;
    }

    public boolean deposit(double amount) {

        if (this.balance >= 0 && !isOpen()) return false;
        this.balance = this.balance + amount;
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

    @Override
    public String toString() {

        if (accountOpen) {
            return this.accountNumber + "(" + type + ") : " + this.accountHolder.toString() + " : " + this.balance + " : Account Open";
        }
        return this.accountNumber + "(" + type + ") : " + this.accountHolder.toString() + " : " + this.balance + " : Account Closed";

    }
}
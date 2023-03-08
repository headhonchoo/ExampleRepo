//Sidney Mcclendon (smcclendon1@csudh.edu)
public class CheckingAccount extends Account {
	private double overdraftLimit;

    public CheckingAccount(int accountNumber, String type, Person accountHolder, double overdraftLimit) {
        super(accountNumber, type, accountHolder);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {

        double balance = super.getBalance() - amount;


        if(!super.isOpen() && balance >= 0){

            return super.withdraw(amount);
        }

        if(!super.isOpen() && balance <= 0){
            return false;
        }

        if ( balance < 0) {

            balance = balance * (-1);

            if (balance <= overdraftLimit) {
                setBalance(balance*-1);
                return true;
            } else {
                return false;
            }
        }


        setBalance(balance*-1);
        return true;
    }

}

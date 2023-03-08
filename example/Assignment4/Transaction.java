//Sidney Mcclendon (smcclendon1@csudh.edu)
import java.util.concurrent.atomic.AtomicInteger;

public class Transaction {
	private String type;
    private double amount;
    private int accountNumber;

    private static final AtomicInteger count = new AtomicInteger(100);
    private final int transaction_id;
    public Transaction(int accountNumber, String type, double amount) {

        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        transaction_id = count.incrementAndGet();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }



    @Override
    public String toString() {
        return transaction_id+" : "+type+" :"+amount;
    }

}

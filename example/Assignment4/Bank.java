//Sidney Mcclendon (smcclendon1@csudh.edu)
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Bank {
	private static Map<Integer, Account> accounts = new TreeMap<>();
	private static int accountNumbers = 100;

	private Bank() {
		
	}
	    
	    public static Account openAccount(String firstName, String lastName, String email, String SSN, String accountType) {
	        Person customer = new Person(firstName, lastName, email, SSN);

	        if (accountType.equals("Checking")) {
	            Scanner scan = new Scanner(System.in);
	            System.out.print("Enter overdraft limit: ");
	            double overDraftLimit = scan.nextDouble();
	            scan.nextLine();
	            CheckingAccount account = new CheckingAccount(accountNumbers++, accountType, customer, overDraftLimit);
	            accounts.put(account.getAccountNumber(), account);
	            return account;
	        }
	        Account account = new Account(accountNumbers++, accountType, customer);
	        accounts.put(account.getAccountNumber(), account);
	        return account;
	    }

	    public static void printAccounts() {

	        for(int n: accounts.keySet()) {
	            System.out.println(accounts.get(n));
	        }
	    }
	    
	    public static Account findAccount(int accountNumber) {
	        return accounts.get(accountNumber);
	    }
	    
	    public static boolean deposit(int accountNumber, double amount) throws AccountClosedException {
	        Account account = accounts.get(accountNumber);
	        if (account != null) {
	            return account.deposit(amount);
	        }
	        return false;
	    }

	    public static boolean withdraw(int accountNumber, double amount) throws AccountClosedException, InsufficientBalanceException {
	        Account account = accounts.get(accountNumber);
	        if (account != null) {
	            if (account.getType().equals("Checking")) {
	                CheckingAccount checkingAccount = (CheckingAccount) account;
	                return checkingAccount.withdraw(amount);
	            }
	            return account.withdraw(amount);
	        }
	        return false;
	    }

	    public static boolean closeAccount(int accountNumber) {
	        Account account = accounts.get(accountNumber);
	        if (account != null) {
	            account.closeAccount();
	            return true;
	        }
	        return false;
	    }
    
  //The following methods must be implemented
	
	
  	/**public Account findAccount(int accountNumber) {
  		
  		1 - If the account exists then return Account object
  		2 - If the account does not exist then return null
  	}
  	
  	
  	public boolean deposit(int accountNumber, amount) {

  		1 - Find account
  		2 - If account not found then return false
  		3 - If account found then deposit money and return the result of the deposit method
  	
      }

      
     	
  	public boolean withdraw(int accountNumber, amount) {

  		1 - Find account
  		2 - If account not found then return false
  		3 - If account found then deposit money and return the result of the withdraw method
  	
      } 
      
      	
  	public boolean closeAccount(int accountNumber) {

  		1 - Find account
  		2 - If account not found then return false
  		3 - If account found then close account and return true
  	
      }
      
      *
      *
      */

}

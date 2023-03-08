//Sidney Mcclendon (smcclendon1@csudh.edu)
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	private static ArrayList<Account> accounts = new ArrayList<Account>();
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
            accounts.add(account);
            return account;
            
        }
        
        Account account = new Account(accountNumbers++, accountType, customer);
        accounts.add(account);
        return account;
     
    }


    public static void printAccounts() {

        for (Account x : accounts) {

            System.out.println(x);
        }
    }

    public static Account findAccount(int accountNumber) {

        for (Account x : accounts) {

            if (x.getAccountNumber() == accountNumber) return x;
        }

        return null;
    }

    public static boolean deposit(int accountNumber, double amount) {
        for (Account x : accounts) {

            if (x.getAccountNumber() == accountNumber) {

                return x.deposit(amount);
            }
        }
        return false;
    }

    public static boolean withdraw(int accountNumber, double amount) {
        for (Account x : accounts) {

            if (x.getAccountNumber() == accountNumber) {

                if (x.getType().equals("Checking")) {

                    CheckingAccount checkingAccount = (CheckingAccount) x;
                    return checkingAccount.withdraw(amount);
                }
                return x.withdraw(amount);
            }
        }
        return false;
    }

    public static boolean closeAccount(int accountNumber) {
        for (Account x : accounts) {

            if (x.getAccountNumber() == accountNumber) {


                x.closeAccount();
                return true;
            }
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


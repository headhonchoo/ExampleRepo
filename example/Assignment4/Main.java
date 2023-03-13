//Sidney Mcclendon (smcclendon1@csudh.edu)
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) throws AccountClosedException, InsufficientBalanceException, NoSuchAccountException {

        Scanner scan = new Scanner(System.in);


        String input;
        do {
            printMenu();
            System.out.print("Please enter your choice: ");
            input = scan.nextLine();
            System.out.println();
            switch (input) {
                case "1":
                case "2":
                    openAccount(scan, input);
                    break;
                case "3":
                    listAccount();
                    break;
                case "4":
                    printAccountStatement(scan);
                    break;
                case "5":
                    makeDeposit(scan);
                    break;
                case "6":
                    makeWithdraw(scan);
                    break;
                case "7":
                    closeAccount(scan);
                    break;
                case "8":
                    System.out.println("Thank you, goodbye ");
                    break;
                default:
                    System.out.println("Wrong input");
            }
        } while (!input.equals("8"));

    }

    private static void closeAccount(Scanner scan) {
        System.out.print("Enter account number to close: ");
        int accountNum = scan.nextInt();
        scan.nextLine();

        Account account = Bank.findAccount(accountNum);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        boolean isSuccess = Bank.closeAccount(accountNum);

        if (isSuccess) {
            System.out.println("Account closed, current balance is " + Bank.findAccount(accountNum).getBalance());
        }
    }

    private static void makeWithdraw(Scanner scan) throws AccountClosedException, InsufficientBalanceException, NoSuchAccountException {
        System.out.print("Enter account number: ");
        int accountNum = scan.nextInt();

        System.out.print("Enter the amount to withdraw: ");
        double amount = scan.nextDouble();
        scan.nextLine();

        Account account = Bank.findAccount(accountNum);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        boolean isSuccess = Bank.withdraw(accountNum, amount);

        if (isSuccess) {
            System.out.println("Withdrawal successful, the new balance is: " + Bank.findAccount(accountNum).getBalance());
            transactions.add(new Transaction(account.getAccountNumber(), "Debit",amount));
        } else {
            System.out.println("Withdrawal failed, the balance is:  " + Bank.findAccount(accountNum).getBalance());
        }
    }

    private static void makeDeposit(Scanner scan) throws AccountClosedException {

        System.out.print("Enter account number: ");
        int accountNum = scan.nextInt();

        System.out.print("Enter the amount to deposit: ");
        double amount = scan.nextDouble();
        scan.nextLine();

        Account account = Bank.findAccount(accountNum);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        boolean isSuccess = Bank.deposit(accountNum, amount);

        if (isSuccess) {
            System.out.println("Deposit successful, the new balance is: " + Bank.findAccount(accountNum).getBalance());
            transactions.add(new Transaction(account.getAccountNumber(), "Credit",amount));
        } else {
            System.out.println("Deposit failed, the balance is: " + Bank.findAccount(accountNum).getBalance());
        }
    }

    private static void printAccountStatement(Scanner scan) {

        System.out.print("Enter account number: ");
        int accountNum = scan.nextInt();
        scan.nextLine();

        Account account = Bank.findAccount(accountNum);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        if (transactions != null) {

            for (Transaction t : transactions) {

                if (t.getAccountNumber() == account.getAccountNumber()) {
                    System.out.println(t);
                }
            }
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("No transactions found");
        }


    }

    private static void listAccount() {

        Bank.printAccounts();
    }

    private static void openAccount(Scanner scan, String input) {
        System.out.print("Enter first name: ");
        String firstName = scan.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scan.nextLine();

        System.out.print("Enter your email: ");
        String email = scan.nextLine();

        System.out.print("Enter social security number: ");
        String SSN = scan.nextLine();
        Account account;

        if (input.equals("1")) {
            account = Bank.openAccount(firstName, lastName, email, SSN, "Checking");
        } else {
            account = Bank.openAccount(firstName, lastName, email, SSN, "Saving");
        }

        System.out.println("Thank you, the account number is " + account.getAccountNumber());

    }

    private static void printMenu() {

        System.out.println("\n1 - Open a Checking account");
        System.out.println("2 - Open a Saving account");
        System.out.println("3 - List Accounts");
        System.out.println("4 - Account Statement");
        System.out.println("5 - Deposit funds");
        System.out.println("6 - Withdraw funds");
        System.out.println("7 - Close an account");
        System.out.println("8 - Exit");
    }

}

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleBankingSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Simple Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> performTransaction(true);   // deposit
                case 3 -> performTransaction(false);  // withdraw
                case 4 -> viewAccount();
                case 5 -> System.out.println("Thank you for using our banking system.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    // Create new bank account
    private static void createAccount() {
        scanner.nextLine();  // consume leftover newline
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double deposit = scanner.nextDouble();
        BankAccount account = new BankAccount(name, deposit);
        accounts.add(account);
        System.out.println("Account created successfully. Account Number: " + account.getAccountNumber());
    }

    // Deposit or Withdraw
    private static void performTransaction(boolean isDeposit) {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        BankAccount account = findAccount(accNumber);

        if (account != null) {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            if (isDeposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    // View account details
    private static void viewAccount() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        BankAccount account = findAccount(accNumber);
        if (account != null) {
            account.displayDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    // Find account by account number
    private static BankAccount findAccount(int accNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                return acc;
            }
        }
        return null;
    }
}

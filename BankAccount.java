
import java.util.ArrayList;
import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private static int accountCounter = 1000;
    private final int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String name, double initialDeposit) {
        this.accountNumber = ++accountCounter;
        this.accountHolderName = name;
        this.balance = initialDeposit;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
}


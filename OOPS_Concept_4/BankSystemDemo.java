package OOPS_Concept_4;

// BankAccount.java

class BankAccount {
    // Static variable shared by all instances of the class
    static String bankName;
    private static int totalAccounts = 0;

    // Final variable: cannot be changed after initialization
    final long accountNumber;

    // Instance variables
    String accountHolderName;
    double balance;

    // Constructor using 'this' to distinguish instance variables from parameters
    public BankAccount(String accountHolderName, long accountNumber) {
        // 'this' refers to the current object's instance variable
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        totalAccounts++; // Increment the static counter for each new account
    }

    // Instance method to display account details
    public void displayAccountDetails() {
        System.out.println("---------------------------------");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + this.accountHolderName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: $" + this.balance);
        System.out.println("---------------------------------");
    }

    // Static method to get the total number of accounts
    public static void getTotalAccounts() {
        System.out.println("Total number of accounts in " + bankName + ": " + totalAccounts);
    }
}

// Main class to run the program
public class BankSystemDemo {
    public static void main(String[] args) {
        // Set the static variable (shared for all objects)
        BankAccount.bankName = "Global Trust Bank";

        // Create instances of BankAccount
        BankAccount acc1 = new BankAccount("Alice", 1122334455L);
        BankAccount acc2 = new BankAccount("Bob", 6677889900L);

        // Demonstrate 'instanceof'
        Object[] objects = {acc1, acc2, "Not An Account"};

        for (Object obj : objects) {
            System.out.println("\nChecking object: " + obj.getClass().getSimpleName());
            // Use 'instanceof' to check if the object is a BankAccount
            if (obj instanceof BankAccount) {
                System.out.println("It is a BankAccount instance. Displaying details...");
                // Cast the object and call its method
                BankAccount account = (BankAccount) obj;
                account.displayAccountDetails();
            } else {
                System.out.println("It is NOT a BankAccount instance.");
            }
        }

        // Call the static method to get the total account count
        System.out.println();
        BankAccount.getTotalAccounts();
    }
}
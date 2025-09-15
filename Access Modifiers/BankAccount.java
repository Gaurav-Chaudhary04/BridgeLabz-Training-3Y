// Problem 3: Bank Account Management
// Create a BankAccount class with:
// accountNumber (public).
// accountHolder (protected).
// balance (private).
// Write methods to:
// Access and modify balance using public methods.
// Create a subclass SavingsAccount to demonstrate access to accountNumber and accountHolder.

package AccessModifiers;

public class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class SavingsAccount extends BankAccount {
    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
    }
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(123456, "Alice", 1500.00);
        savingsAccount.displayDetails();
        savingsAccount.setBalance(2000.00);
        System.out.println("Updated Balance: " + savingsAccount.getBalance());
    }
}

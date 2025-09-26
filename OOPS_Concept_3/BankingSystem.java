package OOPS_Concept_3;

// BankingSystem.java
import java.util.*;

abstract class BankAccount {
    private final String accountNumber;
    private String holderName;
    protected double balance; // protected so subclasses can access safely via methods

    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        if (accountNumber == null || accountNumber.isBlank()) throw new IllegalArgumentException("Invalid account number");
        this.accountNumber = accountNumber;
        setHolderName(holderName);
        this.balance = Math.max(0, initialBalance);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void setHolderName(String holderName) {
        if (holderName == null || holderName.isBlank()) throw new IllegalArgumentException("Holder name required");
        this.holderName = holderName;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw must be positive");
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }

    public abstract double calculateInterest();
}

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate; // annual %
    public SavingsAccount(String accNo, String holder, double balance, double interestRate) {
        super(accNo, holder, balance);
        this.interestRate = Math.max(0, interestRate);
    }

    @Override
    public double calculateInterest() {
        // simple interest for example on current balance yearly
        return balance * (interestRate / 100.0);
    }

    @Override
    public boolean applyForLoan(double amount) {
        // trivial rule: if balance > 20% of requested loan
        return balance >= 0.2 * amount;
    }

    @Override
    public double calculateLoanEligibility() {
        // eligibility amount = 5 * balance for example
        return 5 * balance;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;
    public CurrentAccount(String accNo, String holder, double balance, double overdraftLimit) {
        super(accNo, holder, balance);
        this.overdraftLimit = Math.max(0, overdraftLimit);
    }

    @Override
    public double calculateInterest() {
        // current accounts may have negligible interest
        return 0.0;
    }

    @Override
    public boolean applyForLoan(double amount) {
        // weaker loan eligibility for current accounts unless good balance
        return (balance + overdraftLimit) >= 0.5 * amount;
    }

    @Override
    public double calculateLoanEligibility() {
        return balance + overdraftLimit;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        SavingsAccount s = new SavingsAccount("S001", "Rahul", 100000, 4.0);
        CurrentAccount c = new CurrentAccount("C001", "Meera", 20000, 50000);
        accounts.add(s); accounts.add(c);

        for (BankAccount a : accounts) {
            System.out.printf("Acc: %s | Holder: %s | Balance: %.2f | Interest: %.2f%n",
                    a.getAccountNumber(), a.getHolderName(), a.getBalance(), a.calculateInterest());
            if (a instanceof Loanable) {
                Loanable l = (Loanable) a;
                System.out.printf("  Loan eligible amount: %.2f | Apply for 50000: %s%n",
                        l.calculateLoanEligibility(), l.applyForLoan(50000) ? "Allowed" : "Denied");
            }
            System.out.println("---");
        }
    }
}
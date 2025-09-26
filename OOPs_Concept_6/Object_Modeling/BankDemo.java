package OOPS_Concept_6.Object_Modeling;

import java.util.*;

/**
 * BankDemo: Bank, Customer, Account association example.
 *
 * Compile: javac BankDemo.java
 * Run:     java BankDemo
 */
public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("Demo Bank");
        Customer cust = new Customer("C001", "Gaurav");

        // open account
        Account acc = bank.openAccount(cust, "A1001", 5000.0);
        System.out.println("Opened account: " + acc);
        acc.deposit(1500);
        acc.withdraw(2000);
        System.out.println("Balance after transactions: " + acc.getBalance());

        // customer views accounts
        cust.viewAccounts();
    }
}

/* Supporting classes */
class Customer {
    private String name, id;
    private List<Account> accounts = new ArrayList<>();
    public Customer(String id, String name){ this.id = id; this.name = name; }
    public void addAccount(Account a){ accounts.add(a); }
    public void viewAccounts(){
        System.out.println("Accounts for " + name + ":");
        if(accounts.isEmpty()) System.out.println("  None");
        for(Account a : accounts) System.out.println("  " + a);
    }
    @Override public String toString(){ return id + ":" + name; }
}

class Account {
    private String accNo;
    private double balance;
    public Account(String accNo, double initial){ this.accNo = accNo; this.balance = initial; }
    public void deposit(double d){ balance += d; }
    public boolean withdraw(double d){ if(d<=balance){ balance -= d; return true; } return false; }
    public double getBalance(){ return balance; }
    @Override public String toString(){ return accNo + " - ₹" + balance; }
}

class Bank {
    private String name;
    private List<Account> accounts = new ArrayList<>();
    public Bank(String name){ this.name = name; }
    public Account openAccount(Customer c, String accNo, double init){
        Account a = new Account(accNo, init);
        accounts.add(a);
        c.addAccount(a);
        return a;
    }
}

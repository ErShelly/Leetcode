package org.example.oops;

abstract class BankAccount {
    private String accountHolder;
    private double balance;
    private StringBuffer transactionHistory = new StringBuffer();

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        this.balance += amount;
        transactionHistory.append("Deposited: ").append(amount).append("\n");
        System.out.println("Deposite: " + amount);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.append("Withdrawn: ").append(amount).append("\n");
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void printTransactionHistory(){
        System.out.println(this.transactionHistory);
    }

    public abstract void calculateInterest();
}


class SavingsAcc extends BankAccount{
    public SavingsAcc(String accountHolder, double balance){
        super(accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Savings acc interest");
    }
}

class CurrentAcc extends BankAccount{
    public CurrentAcc(String accountHolder, double balance){
        super(accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Current acc interest");
    }
}
public class BankingSystem {
    public static void main(String[] args){
        SavingsAcc savingsAcc = new SavingsAcc("Shelly", 25000.00);
        CurrentAcc currentAcc = new CurrentAcc("Shelly S", 24000.00);

        Thread t1=new Thread(()->{
            savingsAcc.deposit(500);
            savingsAcc.withdraw(250);
        });

        Thread t2 = new Thread(()->{
            currentAcc.deposit(1000);
            currentAcc.withdraw(250);
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException exception){
            throw new RuntimeException("Exception: "+exception.getMessage());
        }

        savingsAcc.calculateInterest();
        currentAcc.calculateInterest();

        savingsAcc.printTransactionHistory();
        currentAcc.printTransactionHistory();
    }
}

package Handelsakademin.bankprogram;

public class Account {

    private String accountHolder;
    private int pin;
    private double balance;
    private int accountNr;

    public Account(String accountHolder, int pin, double balance, int accountNr) {
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
        this.accountNr = accountNr;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(int accountNr) {
        this.accountNr = accountNr;
    }

    public void deposit(double total) {
        balance += total;
    }

    public void withdraw(double uttagsBelopp) {
        if (uttagsBelopp <= balance) {
            balance -= uttagsBelopp;
        } else {
            System.out.println("Otillräckligt saldo för uttag.");
        }
    }
}



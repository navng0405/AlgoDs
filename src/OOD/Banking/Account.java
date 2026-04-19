package OOD.Banking;

public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    //Deposit method
    public void deposit(double amount) throws InvalidTransactionException{
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit of " + amount + " made. New balance is " + balance);
        } else {
            System.out.println("Invalid deposit amount");
            throw new InvalidTransactionException("Invalid deposit amount :"+amount);
        }
    }

    //Withdraw method - to be implemented by subclasses
    public abstract void withdraw(double amount);

    //Balance inquiry
    public double getBalance() {
        return balance;
    }
}
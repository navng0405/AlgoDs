package OOD.Banking;

public class CheckingAccount extends Account{
    private double overdraftLimit;
    public CheckingAccount(String accountNumber, double initialBalance,double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(amount>0 && (balance+overdraftLimit) >= amount){
            balance = balance-amount;
            System.out.println("Withdrawal of "+ amount + " made. New balance is "+ balance);
        }else{
            System.out.println("Insufficient funds within overdraft limit or invalid withdrawal amount");
        }
    }
}

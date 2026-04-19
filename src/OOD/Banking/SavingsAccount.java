package OOD.Banking;

public class SavingsAccount extends Account{

    private double interestRate;

    public SavingsAccount(String accountNumber,double initialBalance,double interestRate){
        super(accountNumber,initialBalance);
        this.interestRate = interestRate;

    }
    @Override
    public void withdraw(double amount) {
        if(amount>0 && balance>=amount){
            balance = balance-amount;
            System.out.println("Withdrawal of "+ amount + " made.New balance is "+balance);
        }else{
            System.out.println("Insufficient funds or Invalid withdrawal amount");
        }
    }

    //Method to add interst
    public void addInterest() throws InvalidTransactionException {
        double interest = balance*(interestRate/100);
        deposit(interest);
    }
}

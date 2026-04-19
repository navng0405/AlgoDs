package OOD.Banking;

public class BankingDemo {
    public static void main(String[] args) throws InvalidTransactionException {
        SavingsAccount mySavings = new SavingsAccount("12345",1000,2.5);
        CheckingAccount myChecking  = new CheckingAccount("67890C",500,100);

        mySavings.deposit(200);
        mySavings.withdraw(100);
        mySavings.addInterest();
        mySavings.deposit(233);

        myChecking.deposit(300);
        myChecking.withdraw(400);

        System.out.println("Savings Account Balance:  "+ mySavings.getBalance());
        System.out.println("Checking Account Balance: "+ myChecking.getBalance());
    }
}

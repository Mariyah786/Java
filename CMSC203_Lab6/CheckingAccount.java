

public class CheckingAccount extends BankAccount {
    // Static constant for the fee
    private static final double FEE = 0.15;

    // Constructor that takes a name and an initial amount
    public CheckingAccount(String name, double amount) {
        // Call the constructor of the superclass
        super(name, amount);

        // Initialize accountNumber to be the current value in accountNumber concatenated with "-10"
        String newAccountNumber = super.getAccountNumber() + "-10";
        super.setAccountNumber(newAccountNumber);
    }

    // Override the withdraw method
    @Override
    public boolean withdraw(double amount) {
        // Add the fee to the amount to be withdrawn
        double totalAmount = amount + FEE;

        // Call the withdraw method of the superclass and return its result
        return super.withdraw(totalAmount);
    }
}

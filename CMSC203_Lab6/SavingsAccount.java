public class SavingsAccount extends BankAccount {
    // Instance variable for the annual interest rate
    private double rate = 0.025;
    
    // Instance variable for savings number
    private int savingsNumber = 0;
    
    // Instance variable to hide the account number from the superclass
    private String accountNumber;
    
    // Constructor that takes a name and an initial balance as parameters
    public SavingsAccount(String name, double initialBalance) {
        // Call the constructor of the superclass
        super(name, initialBalance);
        
        // Initialize accountNumber to be the current value in the superclass accountNumber concatenated with a hyphen and then the savingsNumber
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }
    
    // Method to post interest
    public void postInterest() {
        // Calculate one month's worth of interest on the balance
        double monthlyInterest = (super.getBalance() * rate) / 12;
        
        // Deposit the interest into the account
        super.deposit(monthlyInterest);
    }
    
    // Override the getAccountNumber method in the superclass
    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    // Copy constructor that creates another savings account for the same person
    public SavingsAccount(SavingsAccount originalAccount, double initialBalance) {
        // Call the copy constructor of the superclass
        super(originalAccount, initialBalance);
        
        // Increment the savings number
        this.savingsNumber = originalAccount.savingsNumber + 1;
        
        // Assign the accountNumber to be the accountNumber of the superclass concatenated with the hyphen and the savingsNumber of the new account
        this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
    }
}

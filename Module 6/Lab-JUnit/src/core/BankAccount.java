package core;

/**
 * This class is used to create a bank account object made up of an account number,
 * account holder name, balance, and account type.
 */
public class BankAccount {
	private String accountNumber,accountHolder;
	private double balance;
	private int accountType;
	
	/**
	 * Constructor that uses default values
	 */
	public BankAccount() {
		super();
		this.accountNumber = "none";
		this.accountHolder = "none";
		this.balance = 0;
		this.accountType = 0;
	}
	
	/**
	 * Constructor that uses passed values.
	 * 
	 * @param accountNumber		String representing the account number
	 * @param accountHolder		String representing the account holder's name
	 * @param balance			Double representing the balance of the account
	 * @param accountType		Integer representing the account type
	 */
	public BankAccount(String accountNumber, String accountHolder, double balance, int accountType) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.accountType = accountType;
	}

	/**
	 * Returns the account number for this object.
	 * 
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number for this object.
	 * 
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Returns the account holder for this object.
	 * 
	 * @return the accountHolder
	 */
	public String getAccountHolder() {
		return accountHolder;
	}

	/**
	 * Sets the account holder for this object.
	 * 
	 * @param accountHolder the accountHolder to set
	 */
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	/**
	 * Returns the balance for this object.
	 * 
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance for this object.
	 * 
	 * @param balance the balance to set
	 * @throws IllegalArgumentException if balance argument is negative
	 */
	public void setBalance(double balance) throws IllegalArgumentException {
		if (balance >= 0)
			this.balance = balance;
		else
			throw new IllegalArgumentException("Balance cannot be negative");
			
	}

	/**
	 * Returns the account type for this object.
	 * 
	 * @return the accountType
	 */
	public int getAccountType() {
		return accountType;
	}

	/**
	 * Sets the account type for this object.
	 * 
	 * @param accountType the accountType to set
	 */
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	
	/**
	 * Returns the interest rate of the account depending on the account type.
	 * 
	 * @return the interest rate on the account
	 */
	public double getInterestRate() {
		double outputIntRate = 0;
		
		// Check account type and set interest rate output accordingly
		switch (this.accountType) {
		case 1:		outputIntRate = 0.5;
			break;
		case 2:		outputIntRate = 4.5;
			break;
		case 3:		outputIntRate = 1;
			break;
		case 4:		outputIntRate = 15;
			break;
		default:	outputIntRate = 0;
			break;
		}
		
		return outputIntRate;
	}
	
	/**
	 * Calculates the total balance of the account using the interest rate on the account.
	 *  
	 * @return the calculated total balance
	 */
	public double calculateTotalBalance() {
		double outputTotalBalance = this.balance + (this.balance * (getInterestRate()/100));
		
		return outputTotalBalance;
	}
	
}

import java.util.Random;
import java.util.ArrayList;

public class BankAccount {
	private double checking;
	private double savings;
//	private Long accountNumber;
	static int numOfAccounts = 0;
	static double totalAmount = 0;
	
	public BankAccount() {
		numOfAccounts++;
	}
	
	public BankAccount (double checking, double savings) {
		this.checking = checking;
		this.savings = savings;
//		this.accountNumber = accountNumber;
		numOfAccounts++;
	}
	
//	private ArrayList<Integer> randAccountNum() {
//		ArrayList<Integer> randomNums = new ArrayList<Integer>();
//		Random rand = new Random();
//		for (int i = 0; i < 10; i++) {
//			randomNums.add(rand.nextInt(10));
//		}
//		return randomNums;
//	}
	
	public String deposit(String account ,double amount) {
		double newBalance = 0.0;
		if (account == "checking") {
			checking += amount;
			newBalance = checking;
		}
		else if (account == "savings") {
			savings += amount;
			newBalance = savings;
		}
		return String.format("Your new balance for %s account: %s", account, newBalance);
	}
	
	public String withdraw(String account, double amount) {
		double newBalance = 0.0;
		if (account == "checking") {
			if (checking - amount <0.0) {
				return "Insufficient funds:";
		}
			else {
				checking -= amount;
				newBalance = checking;
			}
		}
		else if (account == "savings") {
			if (savings - amount <0.0) {
				return "Insufficient funds";
			}
			else {
				savings -= amount;
				newBalance = savings;	
			}
		}
		return String.format("Your new balance for %s account: %s", account, newBalance);

	}
	
	public String totalBalance() {
		double totalBalance = 0.0;
		totalBalance = this.checking + this.savings;
		return String.format("Your total balance for all accounts is %s", totalBalance);
	}
	
	
	

	public double getChecking() {
		return checking;
	}

	public void setChecking(double checking) {
		this.checking = checking;
	}

	public double getSavings() {
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}
	
	
}

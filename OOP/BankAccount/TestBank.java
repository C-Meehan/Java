
public class TestBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account1 = new BankAccount();
		System.out.println(account1.deposit("checking", 50.50));
		System.out.println(account1.deposit("checking", 5.5));
		System.out.println(account1.deposit("checking", 4.0));
		System.out.println(account1.deposit("savings", 100.00));
		System.out.println(account1.withdraw("savings", 50.00));
		System.out.println(account1.getSavings());
		System.out.println(account1.getChecking());
		System.out.println(account1.totalBalance());
//		System.out.println(account1.randAccountNum());
	}
}

package jummate.io.test;
import java.util.Scanner;

public class BankingProgram {
	
	
	

	
	private User user1;
	private User user2;

	public static void main(String[] args) {
		BankingProgram bankingProgram = new BankingProgram();
//		Scanner input = new Scanner(System.in);

	}
	
	public BankingProgram() {
		BankingProgram.start();
		this.user1 = new User("Jane", 24000.00);
		this.user2 = new User("Joe", 50000.00);
		user1.startBanking();
		processRequest(user1.getChoice());
	}
	
	public static void start() {
		System.out.println("========== Welcome To Banking Program ==========");
		showInstruction();
	}
	
	public static void showInstruction() {
		System.out.println("Please Enter:");
		System.out.println("1. to check balance");
		System.out.println("2. to deposit");
		System.out.println("3. to withdraw");
		System.out.println("4. to transfer");
		System.out.println("5. to quit the program\n");
	}
	public static void terminateProgram() {
		System.out.println("Thank you for banking with us. Bye for now.");
		System.exit(1);
	}
	
	public void processRequest(int choice) {
		switch (choice) {
			case 1:
				user1.printBalance();
				break;
			case 2:
				user1.deposit(5000);
			case 3:
				user1.withdraw(2000);
				break;
			case 4:
				user1.transfer(user2, 1000);
			case 5:
				terminateProgram();
				break;
		}
	}
	
	
	
	class User{
		String name;
		double balance;
		int choice;
		String userId;
		Scanner input = new Scanner(System.in);
		
		public User(String name, double balance) {
			this.name = name;
			this.balance = balance;
			this.userId = "12345678"+ name;
			
		}
		public void startBanking() {
			System.out.printf("Welcome %s,\n", getName());
			System.out.print("Please make a choice: ");
			this.setChoice();
			
		}
		
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getChoice() {
			return choice;
		}

		public void setChoice() {
			this.choice = input.nextInt();
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public double getBalance() {
			return this.balance;
		}
		public void setBalance(double newBalance) {
			this.balance = newBalance;
		}
		
		public void printBalance() {
			System.out.printf("Your remaining balance is $%s.\n", getBalance());
			showInstruction();
			setChoice();
			processRequest(getChoice());
 
		}
		
		public void withdraw(double amount) {
			double balance = getBalance();
			if(balance > 0 && amount <= balance) {
				setBalance(balance-amount);
				System.out.println("Amount successfully withdrawn");
			}
			else {
				System.out.println("Insufficent fund!");
			}
			
			showInstruction();
			setChoice();
			processRequest(getChoice());
		}
		
		public void deposit(double amount) {
			double balance = getBalance();
			setBalance(balance+amount);
			System.out.println("Amount successfully deposited");
			showInstruction();
			setChoice();
			processRequest(getChoice());
		}
		
		public void transfer(User recipient, double amount) {
			double balance = getBalance();
			if(balance > 0 && amount <= balance) {
				setBalance(balance-amount);
				recipient.setBalance(recipient.getBalance() + amount);
				System.out.println("Amount successfully transferred");
				showInstruction();
				setChoice();
				processRequest(getChoice());
			}
			else {
				System.out.println("Insufficent fund!");
			}
			
		}
	}
	
	
	

}

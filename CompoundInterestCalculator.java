package jummate.io.test;

import java.util.Scanner;

public class CompoundInterestCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("========== This is a simple program to calculate compund interest =====\n");
		System.out.println("Press");
		System.out.println("1 => to start the program");
		System.out.println("2 => to quit the program at any stage");
		System.out.print("Select an option: ");
		int option = input.nextInt();
		char currency = '$';
		
		while(true) {
			if(option == 2) {
				System.out.println("Exiting program...");
				System.out.println("Program terminates");
				break;
			}
			System.out.print("Enter the principal amount: ");
			double principal = input.nextDouble();
			
			System.out.print("Enter the interest rate (in %): ");
			double rate = input.nextDouble() / 100;
			
			System.out.print("Enter the # of times compounded per year: ");
			double times = input.nextInt();
			
			System.out.print("Enter the # of years: ");
			int years = input.nextInt();
			
			double rateDividedByNumOfYears = rate/years;
			double yearMultipliedByTimes = years*times;
			
			double amount = (double) principal * Math.pow((1 + rateDividedByNumOfYears), yearMultipliedByTimes);
			
			
			System.out.printf("The amount after %d year(s) is %c%.2f\n", years, currency, amount);
			
			System.out.println("\nPress");
			System.out.println("1 => to continue");
			System.out.println("2 => to quit the program");
			System.out.print("Select an option: ");
			option = input.nextInt();
			
		}
		input.close();
		
		

	}

}

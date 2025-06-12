package jummate.io.test;
import java.util.Scanner;
import java.util.Random;

public class DiceRolling {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		int numOfDice;
		int total = 0;
		
		System.out.print("Enter the # of dice to roll: ");
		numOfDice = input.nextInt();
		
		if(numOfDice < 1) {
			System.out.println("# of dice to roll must be greater than 1 ");
			System.exit(0);
		}
		
		for(int x = 0; x < numOfDice; x++) {
			int roll = random.nextInt(1, 7);
			printDie(roll);
			if(roll >= 1 && roll <= 6) total += roll;
		}
		
		System.out.printf("total rolls %d", total);
		input.close();
		

	}
	
	static String createDie(int roll) {
		String die = "";
		
		String die1 = """
				 -------
				|       |
				|   ●   |
				|       |
				 -------
				""";
		String die2 = """
				 -------
				| ●     |
				|       |
				|     ● |
				 -------
				""";
		String die3 = """
				 -------
				| ●     |
				|   ●   |
				|     ● |
				 -------
				""";
		String die4 = """
				 -------
				| ●   ● |
				|       |
				| ●   ● |
				 -------
				""";
		String die5 = """
				 -------
				| ●   ● |
				|   ●   |
				| ●   ● |
				 -------
				""";
		String die6 = """
				 -------
				| ●   ● |
				| ●   ● |
				| ●   ● |
				 -------
				""";
		
		switch(roll) {
			case 1 -> die = die1;
			case 2 -> die = die2;
			case 3 -> die = die3;
			case 4 -> die = die4;
			case 5 -> die = die5;
			case 6 -> die = die6;
			default -> die = "Invalid roll";
		}
		return die;
	}
	
	static void printDie(int roll) {
		System.out.println(createDie(roll));
	}
	
	
	

}

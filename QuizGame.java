
import java.util.Scanner;

public class QuizGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] questions = { "1 + 1 = ?", "2 + 5 = ?", "10 + 5 = ?" };
        String[][] options = {
                { "a. 4", "b. 12", "c. 2" },
                { "a. 7", "b. 10", "c. 5" },
                { "a. 19", "b. 12", "c. 15" }
        };
        String[] answers = { "c", "a", "c" };

        String guess;
        int score = 0;

        System.out.println("======================");
        System.out.println("Welcome to Quiz Game");
        System.out.println("=======================");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(i + 1 + ". " + questions[i]);
            for (String option : options[i]) {
                System.out.print("   " + option);

            }
            System.out.println();
            System.out.print("Enter your guess: ");
            guess = input.nextLine();

            if (guess.equals(answers[i])) {
                score++;
            }

        }
        System.out.printf("You score is %d/%d", score, questions.length);

        input.close();

    }

}

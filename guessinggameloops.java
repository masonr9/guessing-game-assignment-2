import java.util.Random;
import java.util.Scanner;

public class guessinggameloops {
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("***********Number Guessing Game***********");
        System.out.println("********************************************");
        System.out.println("1. Easy: natural numbers");
        System.out.println("2. Medium: real numbers with error threshold 0.5");
        System.out.println("3. Hard: real numbers with error threshold 0.25");
        System.out.println("Choose Difficulty Level (1, 2, or 3):");
        int choice = scnr.nextInt();
        // double guess = scnr.nextDouble();
        // scnr.close();

        switch (choice) {
            case 1:
                Game("Easy",10, 0, 0.0, scnr);
                break;
            case 2:
                Game("Medium", 10, 0.5, 0.0, scnr);
                break;
            case 3:
                Game("Hard", 10, 0.25, 0.0, scnr);
                break;
            default:
                System.out.println("Invalid choice. Exiting the game.");
                break;
        }
        //scnr.close();
    }

    public static void Game(String Difficulty, int range, double errorThreshold, double TotalGuesses, Scanner scnr) {
        // Scanner scnr = new Scanner(System.in);
        // double guess1 = scnr.nextDouble();
        // scnr.close();
        Random random = new Random();
        int totalGames = 3;
        int totalGuesses = 0;
        int i;
        int guesses = 0;
        double secret = 0;

        for (i = 1; i <= totalGames; i++) {
            secret = random.nextDouble() * range;
            if (Difficulty.equals("Easy")){
                secret = Math.floor(secret);
            }

            System.out.println("\nGame " + i + ":");

            while (totalGames < 4) {
                System.out.println("Enter a natural number between that is less than 10");
                // Scanner scanr = new Scanner(System.in);
                double guess = scnr.nextDouble();
                // scanr.close();
                guesses++;
                
                if (guess >= secret - errorThreshold && guess <= secret + errorThreshold) {
                    System.out.println("You win!!!");
                    System.out.println("Number of guesses = " + guesses);
                    break;
                }
                else {
                    System.out.println("Incorrect guess. Try again");
                }
            }
        }

        if (Difficulty.equals("Medium") || Difficulty.equals("Hard")) {
            System.out.print("The secret number was: ");
            System.out.printf("%.2f", secret);
        }
        System.out.println("");
        totalGuesses += guesses;
        System.out.println("Number of guess = " + guesses);      

        double averageGuesses = totalGuesses / totalGames;
        System.out.print("\nAverage number of guesses: ");
        System.out.printf("%.2f", averageGuesses);
        
        scnr.close();
    }
}

import java.util.Scanner;
import java.util.Random;

public class HighLow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        //Game picks a random number between 1 and 100.
        //Prompts user to guess the number
        //All user inputs are validated
        //If user's guess is less than the number, it outputs "HIGHER"
        //If user's guess is more than the number, it outputs "LOWER"
        //If a user guesses the number, the game should declare "GOOD GUESS!"
        Random rand = new Random();
        int myNum = rand.nextInt(100)+1;
        String userResponse;
        System.out.println("Would you like to guess my number?");
        userResponse = sc.next();
        boolean found=false;
        int usrGuesses=0;
        while(!found){
            System.out.println("What number am I thinking of?");
            int userGuess = sc.nextInt();
            usrGuesses++;
            if(userGuess<myNum){
                System.out.println("HIGHER!");
            }
            if(userGuess>myNum){
                System.out.println("LOWER!");
            }
            if(userGuess==myNum){
                System.out.println("GOOD GUESS!! You got it after "+usrGuesses+" guesses!");
                found=true;
            }
        }
    }
}

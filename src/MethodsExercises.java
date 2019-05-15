import java.util.Scanner;
import java.util.Random;
public class MethodsExercises {
    public static void main(String[] args) {
        System.out.println(Multiplication(5,6));
        //Multiplication(999999999, 650);
        int userInput = getInteger(1, 10);
        System.out.println(userInput);


        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Are you sure you want to continue?");
        String response = sc.nextLine();
        if (response.equals("yes")){
            System.out.println(userInput +"! = " + factorial(userInput));
        }
        do{
            System.out.println("Would you like to roll the dice?");
            response = sc.next();
            if(response.equals("yes")) {
                System.out.println("How many?");
                int dieCount = sc.nextInt();
                System.out.println("Enter the number of sides on your dice: ");
                int sidesOfDie = sc.nextInt();
                int diceRoll[] = rollDice(dieCount, sidesOfDie);
                for (int i=0;i<diceRoll.length;i++){
                    System.out.println("Dice #"+(i+1)+" rolled a " +diceRoll[i]+".");
                }
        }
        }while(response.equals("yes"));

    }
    private static void Addition(long a, long b){
        System.out.println(a+b);
    }
    private static void Subtraction(long a, long b){
        System.out.println(a-b);
    }
    private static long Multiplication(long a, long b) {
        if(b>1) {
            a += Multiplication(a, --b);
        }
        return a;
    }
    private static void Division(long a, long b){
        System.out.println(a/b);
    }
    public static int getInteger(int min, int max){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 10: ");
        int inputNumber = sc.nextInt();
        if(inputNumber>max || inputNumber<min){
            inputNumber = getInteger(min,max);
        }
        return inputNumber;
    }
    private static long factorial(int x){
        if (x == 0)
            return 1;
        return x*factorial(--x);
    }

    private static int[] rollDice(int dieCount, int sides){
        int dieResults[] = new int[dieCount];
        Random rand = new Random();
        for(int i=0;i<dieCount;i++){
            dieResults[i]=rand.nextInt(sides)+1;
        }
        return dieResults;
    }
}

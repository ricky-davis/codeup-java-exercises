import java.util.Scanner;
public class MethodsExercises {
    public static void main(String[] args) {
        Multiplication(5,6);
        Multiplication(999999999, 6960);
        int userInput = getInteger(1, 10);
        System.out.println(userInput);
    }
    private static void Addition(long a, long b){
        System.out.println(a+b);
    }
    private static void Subtraction(long a, long b){
        System.out.println(a-b);
    }
    private static void Multiplication(long a, long b) {
        Multiplication(a,0,b);
    }
    private static void Multiplication(long a, long b, long c){
        if(c>0) {
            b+=a;
            c--;
            Multiplication(a, b, c);
        }else{
            System.out.println(a+" * "+(b/a)+" = "+b);
        }
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
}

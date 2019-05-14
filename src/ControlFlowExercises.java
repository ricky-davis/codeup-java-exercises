import java.util.Scanner;
public class ControlFlowExercises {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your numeric grade");
        int input = sc.nextInt();
        char Grade;
        if(input >= 88){
            Grade='A';
        }else if(input >= 80){
            Grade='B';
        }else if(input >= 67){
            Grade='C';
        }else if(input >= 60){
            Grade='D';
        }else {
            Grade='F';
        }
        System.out.println(input + " = " + Grade);
    }
}

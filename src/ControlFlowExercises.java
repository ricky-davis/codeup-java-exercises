import java.util.Scanner;
public class ControlFlowExercises {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number > 10");
        int input = sc.nextInt();
        String buffer =
                "| number | squared | cubed |\n" +
                "| ------ | ------- | ----- |\n";
        String leftAlignFormat = "| %-6d | %-7d | %-5d |%n";
        for(int i=0;i<=input;i++){
            buffer+=String.format(leftAlignFormat, i, i*i,i*i*i);
        }
        System.out.println(buffer);
    }
}

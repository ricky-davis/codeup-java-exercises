package util;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
    }
    public String getString(){
        return this.scanner.next();
    }
    public boolean yesNo(){
        System.out.println("(yes/no)");
        String input = this.scanner.next();
        input = input.toLowerCase();
        return input.equals("y") || input.equals("ye") ||input.equals("yes");
    }
    public int getInt(int min, int max){
        System.out.println("Please enter a value "+min+" >= x <= "+max+"!");
        boolean correct=false;
        int input;
        do {
            input = this.scanner.nextInt();
            if(input >=min && input <=max){
                correct=true;
            }else{
                System.out.println("Please enter a value "+min+" >= x <= "+max+"!");
            }
        }while(!correct);
        return input;
    }
    public int getInt(){
        return this.scanner.nextInt();
    }
    public double getDouble(double min, double max){
        System.out.println("Please enter a value "+min+" >= x <= "+max+"!");
        boolean correct=false;
        double input;
        do {
            input = this.scanner.nextDouble();
            if(input >=min && input <=max){
                correct=true;
            }else{
                System.out.println("Please enter a value "+min+" >= x <= "+max+"!");
            }
        }while(!correct);
        return input;
    }
    public double getDouble(){
        System.out.println("Please enter a double.");
        return this.scanner.nextDouble();
    }
}



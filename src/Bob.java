import java.util.Scanner;

public class Bob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("> ");
            String input = sc.nextLine();

            if(input.equals("")){
                System.out.println("Bob: Fine. Be that way!");
            }else if(input.substring(input.length()-1).equals("?")){
                System.out.println("Bob: Sure.");
            }else if(input.substring(input.length()-1).equals("!")){
                System.out.println("Bob: Whoa, chill out!");
            }else if (input.equals("quit")){
                break;
            }else{
                System.out.println("Bob: Whatever.");
            }
        }
    }
}

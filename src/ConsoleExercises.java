import java.util.Scanner;

public class ConsoleExercises {
    public static void main(String[] args) {
//        double pi = 3.14159;
//        System.out.format("The value of pi is approximately %.2f.%n",pi);
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
//
//        System.out.println("Enter an integer");
        int integer = in.nextInt();
//        System.out.println("Enter 3 words");
//        String string1 = in.next();
//        String string2 = in.next();
//        String string3 = in.next();
//        System.out.println("1 " + string1);
//        System.out.println("2 " + string2);
//        System.out.println("3 " + string3);
//        System.out.println("Enter a sentence");
//        String sentence = in.nextLine();
//        System.out.println(sentence);

        System.out.println("Enter the length, width, and height of the classroom.");
        System.out.print("Length (ft): ");
        float length = Float.parseFloat(in.nextLine());
        System.out.print("Width (ft): ");
        float width = Float.parseFloat(in.nextLine());
        System.out.print("Height (ft): ");
        float height = Float.parseFloat(in.nextLine());

        System.out.printf("The area of the room is %.2f ft^2.%n",length*width);
        System.out.printf("The perimeter of the room is %.2fft.%n",(length*2)+(width*2));
        System.out.printf("The volume of the room is %.2f ft^3.%n",(length*width*height));

    }
}

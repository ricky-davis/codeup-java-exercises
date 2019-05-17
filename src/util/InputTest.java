package util;

public class InputTest {
    public static void main(String[] args) {
        Input input = new Input();
        System.out.println(input.getDouble());
        System.out.println(input.getDouble(1,5));
        System.out.println(input.getInt());
        System.out.println(input.getInt(5,20));
        System.out.println(input.getString());
        System.out.println(input.yesNo());
    }
}

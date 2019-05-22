package shapes;

public class ShapesTest {
    public static void main(String[] args) {
        Measurable myShape = new Square(5);
        Measurable myShape2 = new Rectangle(5,4);
        System.out.println(myShape2.getArea());
        System.out.println(myShape2.getPerimeter());
    }
}

package shapes;

public class Square extends Quadrilateral {

    public Square(int length) {
        super(length, length);
    }

    @Override
    public void setLength(int length) {
        this.setWidth(length);
        this.length=length;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return (2*this.length)+(2*this.width);
    }

    @Override
    public double getArea() {
        return this.length*this.width;
    }
}

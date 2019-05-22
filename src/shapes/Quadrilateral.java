package shapes;

public abstract class Quadrilateral extends Shape implements Measurable {
    protected int length;
    protected int width;

    public Quadrilateral(int length, int width) {
        this.length = length;
        this.width = width;
        this.numSides=4;
    }

    public int getLength() {
        return length;
    }
    public int getWidth() {
        return width;
    }

    public abstract void setLength(int length);
    public abstract void setWidth(int width);

    @Override
    public double getPerimeter() {
        return (2*this.length)+(2*this.width);
    }

    @Override
    public double getArea() {
        return this.length*this.width;
    }
}

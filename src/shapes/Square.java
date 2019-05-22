package shapes;

public class Square extends Quadrilateral {

    public Square(int length) {
        super(length, length);
    }
    public void setLength(int length){
        this.length = length;
        this.width = length;
    }
    public void setWidth(int width){
        this.length = width;
        this.width = width;
    }

}

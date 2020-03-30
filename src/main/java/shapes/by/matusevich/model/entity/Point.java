package shapes.by.matusevich.model.entity;

public class Point implements Cloneable{

    private double x;

    private double y;

    public Point(){}

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point clone() throws CloneNotSupportedException{
        return (Point) super.clone();
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

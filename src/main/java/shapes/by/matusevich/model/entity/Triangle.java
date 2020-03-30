package shapes.by.matusevich.model.entity;


public class Triangle implements Cloneable{

    private Long id;

    private Point point1;

    private Point point2;

    private Point point3;


    public Triangle() {
    }

    public Triangle(Long id, Point point1, Point point2, Point point3) {
        this.id = id;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) throws CloneNotSupportedException {
        this.point1 = point1.clone();
    }

    public Point getPoint2() {  return point2;}

    public void setPoint2(Point point2) throws CloneNotSupportedException {
        this.point2 = point2.clone();
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) throws CloneNotSupportedException {
        this.point3 = point3.clone();
    }

    public Triangle clone() throws CloneNotSupportedException{
        return (Triangle) super.clone();
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                '}';
    }

}

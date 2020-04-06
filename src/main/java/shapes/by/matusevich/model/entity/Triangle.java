package shapes.by.matusevich.model.entity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shapes.by.matusevich.exception.EntityException;
import shapes.by.matusevich.validator.TriangleValidator;

public class Triangle{

    static final Logger logger = LogManager.getLogger();

    private Long id;

    private Point point1;

    private Point point2;

    private Point point3;


    public Triangle() {
    }

    public Triangle(Long id, Point point1, Point point2, Point point3) throws EntityException {
        TriangleValidator validator = new TriangleValidator();
        if(!validator.isTriangle(point1,point2,point3)){
            logger.error("IT ISN'T TRIANGLE");
            throw new EntityException("INCORRECT VALUE");
        }
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

    public Point getPoint1() { return point1; }

    public void setPoint1(Point point1) throws EntityException{
        if (point1 == null) {
            logger.error("INCORRECT VALUE");
            throw new EntityException("INCORRECT VALUE");
        }
        this.point1 = point1;
    }

    public Point getPoint2() {  return point2;}

    public void setPoint2(Point point2)throws EntityException{
        if (point2 == null) {
            logger.error("INCORRECT VALUE");
            throw new EntityException("INCORRECT VALUE");
        }
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) throws EntityException{
        if (point3 == null) {
            logger.error("INCORRECT VALUE");
            throw new EntityException("INCORRECT VALUE");
        }
        this.point3 = point3;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        Triangle triangle = (Triangle)obj;

        return id == triangle.id &&
                point1.equals(triangle.point1) &&
                point2.equals(triangle.point2) &&
                point3.equals(triangle.point3);
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

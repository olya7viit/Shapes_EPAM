package by.matusevich.shapes.model.entity;


import by.matusevich.shapes.observer.TriangleObserver;
import by.matusevich.shapes.observer.impl.AreaTriangleObserver;
import by.matusevich.shapes.observer.impl.PerimeterTriangleObserver;
import by.matusevich.shapes.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.matusevich.shapes.exception.EntityException;
import by.matusevich.shapes.observer.TriangleObservable;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements TriangleObservable {

    final static Logger logger = LogManager.getLogger();

    private Long id;

    private Point point1;

    private Point point2;

    private Point point3;

    private List<TriangleObserver> observers;

    {
        observers = new ArrayList<>();

        observers.add(new PerimeterTriangleObserver());
        observers.add(new AreaTriangleObserver());
    }

    public Triangle() {
        //initializeObservers();
    }

    public Triangle(Long id, Point point1, Point point2, Point point3) throws EntityException {
        TriangleValidator validator = new TriangleValidator();
        if (!validator.isTriangle(point1, point2, point3)) {
            logger.error(new StringBuilder()
                    .append("IT ISN'T TRIANGLE: ")
                    .append(point1).append(" ")
                    .append(point2).append(" ")
                    .append(point3).toString());
            throw new EntityException("INCORRECT VALUE");
        }
        this.id = id;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;

        //initializeObservers();
    }

    /*private void initializeObservers(){
        observers = new ArrayList<>();

        observers.add(new PerimeterTriangleObserver());
        observers.add(new AreaTriangleObserver());
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) throws EntityException {
        if (point1 == null) {
            logger.error("INCORRECT VALUE");
            throw new EntityException("INCORRECT VALUE");
        }
        this.point1 = point1;
        if(point2!=null && point3!=null){
            notifyObservers();
        }
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) throws EntityException {
        if (point2 == null) {
            logger.error("INCORRECT VALUE");
            throw new EntityException("INCORRECT VALUE");
        }
        this.point2 = point2;
        if(point1!=null && point3!=null) {
            notifyObservers();
        }
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) throws EntityException {
        if (point3 == null) {
            logger.error("INCORRECT VALUE");
            throw new EntityException("INCORRECT VALUE");
        }
        this.point3 = point3;
        if(point1!=null && point2!=null) {
            notifyObservers();
        }
    }

    @Override
    public void attach(List<TriangleObserver> observers) {
        this.observers = observers;
    }

    @Override
    public void detach(TriangleObserver observer) {
        observers = null;
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            if (observers.get(i) != null) {
                observers.get(i).triangleUpdate(this);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) obj;

        return id == triangle.id &&
                point1.equals(triangle.point1) &&
                point2.equals(triangle.point2) &&
                point3.equals(triangle.point3);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + id);
        result = prime * result + point1.hashCode();
        result = prime * result + point2.hashCode();
        result = prime * result + point3.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getClass())
                .append("{")
                .append("id=").append(id)
                .append(", point1=").append(point1)
                .append(", point2=").append(point2)
                .append(", point3=").append(point3)
                .append('}').toString();
    }

}

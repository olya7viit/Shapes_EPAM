package by.matusevich.shapes.model.entity.factory;

import by.matusevich.shapes.model.entity.Point;

public class PointFactory {

    private final static PointFactory INSTANCE = new PointFactory();

    private PointFactory() {
    }

    public static PointFactory getInstance() {
        return INSTANCE;
    }

    public Point getPoint() {
        return new Point();
    }

    public Point getPoint(double x, double y){
        return new Point(x,y);
    }

}

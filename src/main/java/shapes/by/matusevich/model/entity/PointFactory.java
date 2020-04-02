package shapes.by.matusevich.model.entity;

public class PointFactory {

    private static final PointFactory INSTANCE = new PointFactory();

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

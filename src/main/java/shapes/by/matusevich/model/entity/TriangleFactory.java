package shapes.by.matusevich.model.entity;

public class TriangleFactory {

    private static final int ID_POSITION = 0;

    private static final TriangleFactory INSTANCE = new TriangleFactory();

    private TriangleFactory() {
    }

    public static TriangleFactory getInstance() {
        return INSTANCE;
    }

    public Triangle getTriangle() {
        return new Triangle();
    }

    public Triangle getTriangle(String[] data) throws EntityException {

        Triangle triangle = TriangleFactory.getInstance().getTriangle();

        triangle.setId(Long.parseLong(data[ID_POSITION]));

        Point point1 = PointFactory.getInstance().getPoint(Double.parseDouble(data[1]),Double.parseDouble(data[2]));
        triangle.setPoint1(point1);

        Point point2 = PointFactory.getInstance().getPoint(Double.parseDouble(data[3]),Double.parseDouble(data[4]));
        triangle.setPoint2(point2);

        Point point3 = PointFactory.getInstance().getPoint(Double.parseDouble(data[5]),Double.parseDouble(data[6]));
        triangle.setPoint3(point3);

        return triangle;
    }

}

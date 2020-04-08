package shapes.by.matusevich.model.entity;

import shapes.by.matusevich.exception.EntityException;
import shapes.by.matusevich.exception.ServiceException;
import shapes.by.matusevich.exception.WareHouseException;
import shapes.by.matusevich.model.generator.IdGenerator;

public class TriangleFactory {

    private static final String REGEX_DELIMITER = "\\s+";
    private static final int X1_POSITION = 0;
    private static final int Y1_POSITION = 1;
    private static final int X2_POSITION = 2;
    private static final int Y2_POSITION = 3;
    private static final int X3_POSITION = 4;
    private static final int Y3_POSITION = 5;

    private static final TriangleFactory INSTANCE = new TriangleFactory();

    private TriangleFactory() {
    }

    public static TriangleFactory getInstance() {
        return INSTANCE;
    }

    public Triangle getTriangle() {
        return new Triangle();
    }

    public Triangle getTriangle(String lineTriangle) throws EntityException, ServiceException, WareHouseException {

        double X, Y;
        String[] data = lineTriangle.split(REGEX_DELIMITER);

        Triangle triangle = TriangleFactory.getInstance().getTriangle();

        long idTriangle;
        idTriangle = IdGenerator.generateId();
        triangle.setId(idTriangle);

        X = Double.parseDouble(data[X1_POSITION]);
        Y = Double.parseDouble(data[Y1_POSITION]);
        Point point1 = PointFactory.getInstance().getPoint(X, Y);
        triangle.setPoint1(point1);

        X = Double.parseDouble(data[X2_POSITION]);
        Y = Double.parseDouble(data[Y2_POSITION]);
        Point point2 = PointFactory.getInstance().getPoint(X, Y);
        triangle.setPoint2(point2);

        X = Double.parseDouble(data[X3_POSITION]);
        Y = Double.parseDouble(data[Y3_POSITION]);
        Point point3 = PointFactory.getInstance().getPoint(X, Y);
        triangle.setPoint3(point3);

        return triangle;
    }

}

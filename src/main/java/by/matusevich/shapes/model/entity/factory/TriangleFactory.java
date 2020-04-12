package by.matusevich.shapes.model.entity.factory;

import by.matusevich.shapes.exception.EntityException;
import by.matusevich.shapes.exception.ServiceException;
import by.matusevich.shapes.exception.WareHouseException;
import by.matusevich.shapes.model.entity.Point;
import by.matusevich.shapes.model.entity.Triangle;
import by.matusevich.shapes.model.generator.IdGenerator;

public class TriangleFactory {

    private final static String REGEX_DELIMITER = "\\s+";
    private final static int X1_POSITION = 0;
    private final static int Y1_POSITION = 1;
    private final static int X2_POSITION = 2;
    private final static int Y2_POSITION = 3;
    private final static int X3_POSITION = 4;
    private final static int Y3_POSITION = 5;

    private final static TriangleFactory INSTANCE = new TriangleFactory();

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

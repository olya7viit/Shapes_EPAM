package shapes.by.matusevich.validator;

import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.entity.factory.EntityFactory;
import shapes.by.matusevich.model.service.impl.TriangleServiceImpl;

import java.util.List;

public class Validator {

    private static final String PARAM_DELIMITER = " ";
    private static final int COUNT_ELEMENT = 7;
    private static final int ID_POSITION = 0;

    public static boolean isTriangle(Point point1, Point point2, Point point3) {
        double a, b, c;

        a = TriangleServiceImpl.getSide(point1, point2);
        b = TriangleServiceImpl.getSide(point2, point3);
        c = TriangleServiceImpl.getSide(point3, point1);

        boolean result = false;
        if (a + b > c && a + c > b && b + c > a) {
            result = true;
        }

        return result;
    }

    public static boolean isTriangle(Triangle triangle){
        double a, b, c;

        a = TriangleServiceImpl.getSide(triangle.getPoint1(), triangle.getPoint2());
        b = TriangleServiceImpl.getSide(triangle.getPoint2(), triangle.getPoint3());
        c = TriangleServiceImpl.getSide(triangle.getPoint3(), triangle.getPoint1());

        boolean result = false;
        if (a + b > c && a + c > b && b + c > a) {
            result = true;
        }

        return result;
    }

    public static List<Triangle> checkTriangleFromFile(List<Triangle> triangles, String str) {
        boolean flag = true;
        String[] splitLine;
        splitLine = str.split(PARAM_DELIMITER);

        if (splitLine.length == COUNT_ELEMENT) {
            if (!isLong(splitLine[ID_POSITION])) {
                flag = false;
            }
            if (!isDouble(splitLine[1]) || !isDouble(splitLine[2])) {
                flag = false;
            }
            if (!isDouble(splitLine[3]) || !isDouble(splitLine[4])) {
                flag = false;
            }
            if (!isDouble(splitLine[5]) || !isDouble(splitLine[6])) {
                flag = false;
            }
            if (flag) {

                Point point;
                point = EntityFactory.getInstance().getPoint();

                Triangle triangle;
                triangle = EntityFactory.getInstance().getTriangle();

                triangle.setId(Long.parseLong(splitLine[ID_POSITION]));

                point.setX(Double.parseDouble(splitLine[1]));
                point.setY(Double.parseDouble(splitLine[2])); 
                triangle.setPoint1(point);

                point.setX(Double.parseDouble(splitLine[3]));
                point.setY(Double.parseDouble(splitLine[4]));
                triangle.setPoint2(point);

                point.setX(Double.parseDouble(splitLine[5]));
                point.setY(Double.parseDouble(splitLine[6]));
                triangle.setPoint3(point);

                triangles.add(triangle);
            }
        }

        return triangles;

    }

    public static boolean isDouble(String value) {
        if ((double)Double.parseDouble(value) == Double.parseDouble(value)) {
            return true;
        }
        return false;
    }

    public static boolean isInteger(String value) {
        if ((int)Integer.parseInt(value) == Integer.parseInt(value)) {
            return true;
        }
        return false;
    }

    public static boolean isLong(String value) {
        if ((long)Long.parseLong(value) == Long.parseLong(value)) {
            return true;
        }
        return false;
    }
}
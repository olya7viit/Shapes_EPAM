package shapes.by.matusevich.validator;

import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.service.impl.TriangleServiceImpl;

public class Validator {

    private static final int ID_POSITION = 0;
    private static final int X1_POSITION = 1;
    private static final int Y1_POSITION = 2;
    private static final int X2_POSITION = 3;
    private static final int Y2_POSITION = 4;
    private static final int X3_POSITION = 5;
    private static final int Y4_POSITION = 6;
    private static final String REGEX_NUMBER = "^\\d+$";
    private static final String REGEX_DOUBLE_NUMBER = "^\\d*[.,]?\\d+$";
    private static final String PARAM_DELIMITER = " ";

    public boolean isTriangle(Point point1, Point point2, Point point3) {
        double a, b, c;

        a = TriangleServiceImpl.calculateSide(point1, point2);
        b = TriangleServiceImpl.calculateSide(point2, point3);
        c = TriangleServiceImpl.calculateSide(point3, point1);

        boolean result = false;
        if (a + b > c && a + c > b && b + c > a) {
            result = true;
        }

        return result;
    }

    public boolean isTriangle(Triangle triangle) {
        double a, b, c;

        a = TriangleServiceImpl.calculateSide(triangle.getPoint1(), triangle.getPoint2());
        b = TriangleServiceImpl.calculateSide(triangle.getPoint2(), triangle.getPoint3());
        c = TriangleServiceImpl.calculateSide(triangle.getPoint3(), triangle.getPoint1());

        boolean result = false;
        if (a + b > c && a + c > b && b + c > a) {
            result = true;
        }

        return result;
    }

    public boolean isDouble(String value) {
        return value.matches(REGEX_DOUBLE_NUMBER);
    }

    public boolean isLong(String value) {
        return value.matches(REGEX_NUMBER);
    }

    public boolean isCorrectData(String line, int countElement) {
        boolean flag = false;
        String[] splitLine;

        splitLine = line.split(PARAM_DELIMITER);

        if (splitLine.length == countElement) {
            flag = true;

            if (!isLong(splitLine[ID_POSITION])) {
                flag = false;
            }
            if (!isDouble(splitLine[X1_POSITION]) || !isDouble(splitLine[Y1_POSITION])) {
                flag = false;
            }
            if (!isDouble(splitLine[X2_POSITION]) || !isDouble(splitLine[Y2_POSITION])) {
                flag = false;
            }
            if (!isDouble(splitLine[X3_POSITION]) || !isDouble(splitLine[Y4_POSITION])) {
                flag = false;
            }
        }

        return flag;
    }
}
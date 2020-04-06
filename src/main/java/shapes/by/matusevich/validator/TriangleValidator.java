package shapes.by.matusevich.validator;

import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.service.impl.TriangleServiceImpl;

public class TriangleValidator {

    private static final int X1_POSITION = 0;
    private static final int Y1_POSITION = 1;
    private static final int X2_POSITION = 2;
    private static final int Y2_POSITION = 3;
    private static final int X3_POSITION = 4;
    private static final int Y3_POSITION = 5;

    private static final String REGEX_DELIMITER = "\\s+";

    public boolean isTriangle(Point point1, Point point2, Point point3) {

        if(point1 == null || point2 == null || point3 == null){
            return false;
        }

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

        if(triangle == null){
           return false;
        }

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

    public boolean isCorrectData(String line, int countElement) {

        if(line == null){
            return false;
        }

        ValueValidator valueValidator = new ValueValidator();

        boolean flag = false;
        String[] splitLine;
        splitLine = line.split(REGEX_DELIMITER);

        if (splitLine.length == countElement) {
            flag = true;

            if (!valueValidator.isDouble(splitLine[X1_POSITION]) ||
                    !valueValidator.isDouble(splitLine[Y1_POSITION])) {
                flag = false;
            }
            if (!valueValidator.isDouble(splitLine[X2_POSITION]) ||
                    !valueValidator.isDouble(splitLine[Y2_POSITION])) {
                flag = false;
            }
            if (!valueValidator.isDouble(splitLine[X3_POSITION]) ||
                    !valueValidator.isDouble(splitLine[Y3_POSITION])) {
                flag = false;
            }
        }

        return flag;
    }
}
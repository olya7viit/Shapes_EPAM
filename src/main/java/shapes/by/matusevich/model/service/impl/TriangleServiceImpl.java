package shapes.by.matusevich.model.service.impl;

import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.exception.ServiceException;
import shapes.by.matusevich.model.service.TriangleService;
import shapes.by.matusevich.validator.TriangleValidator;

public class TriangleServiceImpl implements TriangleService {

    private static final int SIDE1_POSITION = 0;
    private static final int SIDE2_POSITION = 1;
    private static final int SIDE3_POSITION = 2;
    private TriangleValidator validator = new TriangleValidator();

    @Override
    public double calculateArea(Triangle triangle) throws ServiceException {

        if (!validator.isTriangle(triangle)) {
            throw new ServiceException("it isn't triangle");
        }

        double[] sides = calculateSides(triangle);

        double perimeter;
        perimeter = calculatePerimeter(triangle) / 2;

        double area;
        area = Math.sqrt(perimeter *
                (perimeter - sides[SIDE1_POSITION]) *
                (perimeter - sides[SIDE2_POSITION]) *
                (perimeter - sides[SIDE3_POSITION]));

        return area;
    }

    @Override
    public double calculatePerimeter(Triangle triangle) throws ServiceException {

        if (!validator.isTriangle(triangle)) {
            throw new ServiceException("it isn't triangle");
        }

        double[] sides = calculateSides(triangle);

        double perimeter;
        perimeter = sides[SIDE1_POSITION] +
                sides[SIDE2_POSITION] +
                sides[SIDE3_POSITION];

        return perimeter;
    }

    @Override
    public boolean isRectangular(Triangle triangle) throws ServiceException {

        if (!validator.isTriangle(triangle)) {
            throw new ServiceException("it isn't triangle");
        }

        boolean result = false;

        double[] sides = calculateSides(triangle);

        if (sides[SIDE1_POSITION] == Math.sqrt(Math.sqrt(sides[SIDE2_POSITION]) + Math.sqrt(sides[SIDE3_POSITION])) ||
                sides[SIDE2_POSITION] == Math.sqrt(Math.sqrt(sides[SIDE1_POSITION]) + Math.sqrt(sides[SIDE3_POSITION])) ||
                sides[SIDE3_POSITION] == Math.sqrt(Math.sqrt(sides[SIDE2_POSITION]) + Math.sqrt(sides[SIDE1_POSITION]))) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean isEquilateral(Triangle triangle) throws ServiceException {

        if (!validator.isTriangle(triangle)) {
            throw new ServiceException("it isn't triangle");
        }

        boolean result = false;

        double[] sides = calculateSides(triangle);

        if (sides[SIDE1_POSITION] == sides[SIDE2_POSITION] && sides[SIDE2_POSITION] == sides[SIDE3_POSITION]) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean isIsosceles(Triangle triangle) throws ServiceException {
        if (!validator.isTriangle(triangle)) {
            throw new ServiceException("it isn't triangle");
        }

        boolean result = false;

        double[] sides = calculateSides(triangle);

        if (sides[SIDE1_POSITION] == sides[SIDE2_POSITION] ||
                sides[SIDE2_POSITION] == sides[SIDE3_POSITION] ||
                sides[SIDE3_POSITION] == sides[SIDE1_POSITION]) {
            result = true;
        }

        return result;
    }

    public static double calculateSide(Point point1, Point point2) {
        double x1, y1;
        x1 = point1.getX();
        y1 = point1.getY();

        double x2, y2;
        x2 = point2.getX();
        y2 = point2.getY();

        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public double[] calculateSides(Triangle triangle) throws ServiceException {

        if (!validator.isTriangle(triangle)) {
            throw new ServiceException("it isn't triangle");
        }

        double[] sides = new double[3];

        sides[SIDE1_POSITION] = calculateSide(triangle.getPoint1(), triangle.getPoint2());
        sides[SIDE2_POSITION] = calculateSide(triangle.getPoint2(), triangle.getPoint3());
        sides[SIDE3_POSITION] = calculateSide(triangle.getPoint3(), triangle.getPoint1());

        return sides;
    }
}

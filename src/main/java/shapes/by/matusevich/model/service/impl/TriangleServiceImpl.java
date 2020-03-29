package shapes.by.matusevich.model.service.impl;

import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.service.TriangleService;
import shapes.by.matusevich.validator.Validator;

public class TriangleServiceImpl implements TriangleService {
    @Override
    public double calculateArea(Triangle triangle) {

        if(!Validator.isTriangle(triangle)){
            //исключение
        }

        double[] sides = getSides(triangle);

        double perimeter;
        perimeter = calculatePerimeter(triangle);

        double area;
        area = Math.sqrt(perimeter * (perimeter - sides[0]) * (perimeter - sides[1]) * (perimeter - sides[2]));

        return area;
    }

    @Override
    public double calculatePerimeter(Triangle triangle) {

        if(!Validator.isTriangle(triangle)){
            //исключение
        }

        double[] sides = getSides(triangle);

        double perimeter;
        perimeter = sides[0] + sides[1] + sides[2];

        return perimeter;
    }

    @Override
    public boolean isRectangular(Triangle triangle) {

        if (!Validator.isTriangle(triangle)) {
            //исключение
        }

        boolean result = false;

        double[] sides = getSides(triangle);

        if (sides[0] == Math.sqrt(Math.sqrt(sides[1]) + Math.sqrt(sides[2])) ||
                sides[1] == Math.sqrt(Math.sqrt(sides[0]) + Math.sqrt(sides[2])) ||
                sides[2] == Math.sqrt(Math.sqrt(sides[1]) + Math.sqrt(sides[0]))) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean isEquilateral(Triangle triangle) {

        if(!Validator.isTriangle(triangle)){
            //исключение
        }

        boolean result = false;

        double[] sides = getSides(triangle);

        if(sides[0] == sides[1] && sides[1] == sides[2]){
            result = true;
        }

        return result;
    }

    @Override
    public boolean isIsosceles(Triangle triangle) {
        if(!Validator.isTriangle(triangle)){
            //исключение
        }

        boolean result = false;

        double[] sides = getSides(triangle);

        if(sides[0] == sides[1] || sides[1] == sides[2] || sides[2] == sides[0]){
            result = true;
        }

        return result;
    }

    public static double getSide(Point point1, Point point2){
        double x1,y1;
        x1 = point1.getX();
        y1 = point1.getY();

        double x2,y2;
        x2 = point2.getX();
        y2 = point2.getY();

        return Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
    }

    public static double[] getSides(Triangle triangle){

        if(!Validator.isTriangle(triangle)){
            //исключение
        }

        double[] sides = new double[3];

        sides[0] = getSide(triangle.getPoint1(), triangle.getPoint2());
        sides[1] = getSide(triangle.getPoint2(), triangle.getPoint3());
        sides[2] = getSide(triangle.getPoint3(), triangle.getPoint1());

        return sides;
    }
}

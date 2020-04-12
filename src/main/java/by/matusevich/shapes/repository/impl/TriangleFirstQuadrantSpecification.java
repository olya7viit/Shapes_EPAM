package by.matusevich.shapes.repository.impl;

import by.matusevich.shapes.model.entity.Point;
import by.matusevich.shapes.model.entity.Triangle;
import by.matusevich.shapes.repository.Specification;

import java.util.ArrayList;
import java.util.List;

public class TriangleFirstQuadrantSpecification implements Specification {

    @Override
    public boolean test(Triangle triangle) {
        boolean flag = true;
        List<Point> pointList = new ArrayList<>();
        pointList.add(triangle.getPoint1());
        pointList.add(triangle.getPoint2());
        pointList.add(triangle.getPoint3());

        for (int i = 0; i < pointList.size(); i++) {
            if (pointList.get(i).getX() <= 0 || pointList.get(i).getY() <= 0) {
                flag = false;
            }
        }
        return flag;
    }
}

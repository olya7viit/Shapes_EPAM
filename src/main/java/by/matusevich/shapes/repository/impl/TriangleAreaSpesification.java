package by.matusevich.shapes.repository.impl;

import by.matusevich.shapes.model.entity.Triangle;
import by.matusevich.shapes.observer.WareHouse;
import by.matusevich.shapes.repository.Specification;

public class TriangleAreaSpesification implements Specification {

    private double area;

    public TriangleAreaSpesification(double area) {
        this.area = area;
    }

    @Override
    public boolean test(Triangle triangle) {
        WareHouse wareHouse = WareHouse.getInstance();
        double triangleArea = wareHouse.getArea(triangle.getId());
        return area == triangleArea;
    }
}

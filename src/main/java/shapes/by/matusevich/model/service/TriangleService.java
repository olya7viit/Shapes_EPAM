package shapes.by.matusevich.model.service;

import shapes.by.matusevich.model.entity.Triangle;

public interface TriangleService {

    double calculateArea(Triangle triangle);

    double calculatePerimeter(Triangle triangle);

    boolean isRectangular(Triangle triangle);  //прямоугольный

    boolean isEquilateral(Triangle triangle); //равносторонний

    boolean isIsosceles(Triangle triangle);  //равнобедренный


}

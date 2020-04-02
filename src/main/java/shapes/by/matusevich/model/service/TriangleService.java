package shapes.by.matusevich.model.service;

import shapes.by.matusevich.model.entity.Triangle;

public interface TriangleService {

    double calculateArea(Triangle triangle) throws ServiceException;

    double calculatePerimeter(Triangle triangle) throws ServiceException;

    boolean isRectangular(Triangle triangle) throws ServiceException;  //прямоугольный

    boolean isEquilateral(Triangle triangle) throws ServiceException; //равносторонний

    boolean isIsosceles(Triangle triangle) throws ServiceException;  //равнобедренный


}

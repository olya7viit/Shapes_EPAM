package by.matusevich.shapes.repository;

import by.matusevich.shapes.model.entity.Triangle;

import java.util.List;

public interface TriangleRepository {
    boolean add(Triangle triangle);

    boolean addAll(List<Triangle> triangleList);

    Triangle get(int index);

    int size();

    boolean remove(Triangle triangle);

    List<Triangle> query(Specification specification);
}

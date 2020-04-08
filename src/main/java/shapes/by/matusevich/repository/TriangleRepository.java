package shapes.by.matusevich.repository;

import shapes.by.matusevich.model.entity.Triangle;

import java.util.List;

public interface TriangleRepository {
    boolean addTriangle(Triangle triangle);

    boolean addAllTriangles(List<Triangle> triangleList);

    Triangle getTriangle(int index);

    int size();

    boolean removeTriangle(Triangle triangle);

    List<Triangle> query(Specification specification);
}

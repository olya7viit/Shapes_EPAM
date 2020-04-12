package by.matusevich.shapes.repository.impl;

import by.matusevich.shapes.model.entity.Triangle;
import by.matusevich.shapes.repository.Specification;

public class TriangleIdSpecification implements Specification {

    private long id;

    public TriangleIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean test(Triangle triangle) {
        return id == triangle.getId();
    }
}

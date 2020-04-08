package shapes.by.matusevich.repository.impl;

import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.repository.Specification;

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

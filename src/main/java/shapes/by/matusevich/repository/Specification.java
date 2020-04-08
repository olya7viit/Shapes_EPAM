package shapes.by.matusevich.repository;

import shapes.by.matusevich.model.entity.Triangle;

import java.util.function.Predicate;

@FunctionalInterface
public interface Specification extends Predicate<Triangle> {
}

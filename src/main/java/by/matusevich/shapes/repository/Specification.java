package by.matusevich.shapes.repository;

import by.matusevich.shapes.model.entity.Triangle;

import java.util.function.Predicate;

@FunctionalInterface
public interface Specification extends Predicate<Triangle> {
}

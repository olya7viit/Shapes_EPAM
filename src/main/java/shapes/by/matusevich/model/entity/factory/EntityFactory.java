package shapes.by.matusevich.model.entity.factory;

import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;

public class EntityFactory {

    private static final EntityFactory INSTANCE = new EntityFactory();

    private final Point point = new Point();

    private final Triangle triangle = new Triangle();

    private EntityFactory() {
    }

    public static EntityFactory getInstance() {
        return INSTANCE;
    }

    public Point getPoint() {
        return point;
    }

    public Triangle getTriangle() {
        return triangle;
    }

}

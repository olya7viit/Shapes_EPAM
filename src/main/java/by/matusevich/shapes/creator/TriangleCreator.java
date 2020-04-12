package by.matusevich.shapes.creator;

import by.matusevich.shapes.exception.CreatorException;
import by.matusevich.shapes.exception.EntityException;
import by.matusevich.shapes.exception.ServiceException;
import by.matusevich.shapes.exception.WareHouseException;
import by.matusevich.shapes.model.entity.Triangle;

import java.util.List;

public interface TriangleCreator {
    List<Triangle> createTriangles(List<String> correctListTriangles) throws EntityException, CreatorException, ServiceException, WareHouseException;
}

package shapes.by.matusevich.creator;

import shapes.by.matusevich.exception.CreatorException;
import shapes.by.matusevich.exception.EntityException;
import shapes.by.matusevich.exception.ServiceException;
import shapes.by.matusevich.exception.WareHouseException;
import shapes.by.matusevich.model.entity.Triangle;

import java.util.List;

public interface TriangleCreator {
    List<Triangle> createTriangles(List<String> correctListTriangles) throws EntityException, CreatorException, ServiceException, WareHouseException;
}

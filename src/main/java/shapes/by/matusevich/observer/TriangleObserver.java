package shapes.by.matusevich.observer;

import shapes.by.matusevich.exception.ServiceException;
import shapes.by.matusevich.exception.WareHouseException;
import shapes.by.matusevich.model.entity.Triangle;

public interface TriangleObserver {

    void triangleUpdate(Triangle triangle) throws ServiceException, WareHouseException;
}

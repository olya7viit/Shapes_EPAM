package shapes.by.matusevich.observer.impl;

import shapes.by.matusevich.exception.ServiceException;
import shapes.by.matusevich.exception.WareHouseException;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.service.TriangleService;
import shapes.by.matusevich.model.service.impl.TriangleServiceImpl;
import shapes.by.matusevich.observer.TriangleObserver;
import shapes.by.matusevich.observer.WareHouse;

public class AreaTriangleObserver implements TriangleObserver {
    @Override
    public void triangleUpdate(Triangle triangle) throws ServiceException, WareHouseException {
        TriangleService triangleService = new TriangleServiceImpl();

        long idTriangle;
        idTriangle = triangle.getId();

        double area;
        area = triangleService.calculateArea(triangle);

        WareHouse wareHouse = WareHouse.getInstance();
        wareHouse.saveArea(idTriangle, area);
    }
}

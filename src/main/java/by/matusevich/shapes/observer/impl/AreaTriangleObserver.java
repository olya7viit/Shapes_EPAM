package by.matusevich.shapes.observer.impl;

import by.matusevich.shapes.exception.ServiceException;
import by.matusevich.shapes.exception.WareHouseException;
import by.matusevich.shapes.observer.TriangleObserver;
import by.matusevich.shapes.model.entity.Triangle;
import by.matusevich.shapes.model.service.TriangleService;
import by.matusevich.shapes.model.service.impl.TriangleServiceImpl;
import by.matusevich.shapes.observer.WareHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AreaTriangleObserver implements TriangleObserver {

    final static Logger logger = LogManager.getLogger();

    @Override
    public void triangleUpdate(Triangle triangle) {
        TriangleService triangleService = new TriangleServiceImpl();

        long idTriangle;
        idTriangle = triangle.getId();

        double area;
        try {
            area = triangleService.calculateArea(triangle);
            WareHouse wareHouse = WareHouse.getInstance();
            wareHouse.putArea(idTriangle, area);

        } catch (ServiceException | WareHouseException e) {
            logger.error("errors in the update triangle's area");
        }


    }
}

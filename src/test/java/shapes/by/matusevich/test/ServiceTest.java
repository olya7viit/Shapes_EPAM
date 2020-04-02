package shapes.by.matusevich.test;

import org.junit.Assert;
import org.junit.Test;
import shapes.by.matusevich.model.entity.EntityException;
import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.service.ServiceException;
import shapes.by.matusevich.model.service.TriangleService;
import shapes.by.matusevich.model.service.impl.TriangleServiceImpl;

public class ServiceTest {

    @Test
    public void calculateAreaTest1() throws EntityException, ServiceException {
        TriangleService triangleService = new TriangleServiceImpl();

        double area = triangleService.calculateArea(new Triangle(
                (long)1,
                new Point(1,1),
                new Point(1,5),
                new Point(5,1)));
        Assert.assertEquals(8, area, 0.001);
    }

    @Test(expected = EntityException.class)
    public void calculateAreaTest2() throws EntityException, ServiceException {
        TriangleService triangleService = new TriangleServiceImpl();

        double area = triangleService.calculateArea(new Triangle(
                (long)1,
                new Point(1,1),
                new Point(1,5),
                new Point(1,1)));
        Assert.assertEquals(8, area, 0.001);
    }

}

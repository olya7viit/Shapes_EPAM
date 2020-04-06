package shapes.by.matusevich.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shapes.by.matusevich.model.entity.EntityException;
import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.entity.TriangleFactory;
import shapes.by.matusevich.model.service.ServiceException;
import shapes.by.matusevich.model.service.TriangleService;
import shapes.by.matusevich.model.service.impl.TriangleServiceImpl;

public class TriangleServiceImplTest {

    private Triangle testTriangle;
    private TriangleService triangleService;

    @BeforeClass
    public void initialisation() throws EntityException {

        triangleService = new TriangleServiceImpl();

        String[] data = {"1", "1", "1", "1", "5", "5", "1"};
        testTriangle = TriangleFactory.getInstance().getTriangle(data);
    }

    @Test
    public void calculateAreaTest() throws ServiceException {
        double area = triangleService.calculateArea(testTriangle);
        Assert.assertEquals(8, area, 0.001);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void calculateAreaTestNull() throws ServiceException {
        double area = triangleService.calculateArea(null);
    }

    @Test(expectedExceptions = EntityException.class)
    public void calculateAreaTestExceptions() throws EntityException, ServiceException {

        double area = triangleService.calculateArea(new Triangle(
                (long)1,
                new Point(1,1),
                new Point(1,5),
                new Point(1,1)));
    }

    @Test
    public void calculatePerimeterTest() throws ServiceException {
        double expected = 13.65;
        double perimeter = triangleService.calculatePerimeter(testTriangle);
        Assert.assertEquals(expected, perimeter, 0.01);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void calculatePerimeterTestNull() throws ServiceException {
        triangleService.calculatePerimeter(null);
    }

    @Test(expectedExceptions = EntityException.class)
    public void calculatePerimeterTestExceptions() throws EntityException, ServiceException {

        triangleService.calculatePerimeter(new Triangle(
                (long)1,
                new Point(1,1),
                new Point(1,5),
                new Point(1,1)));
    }
}

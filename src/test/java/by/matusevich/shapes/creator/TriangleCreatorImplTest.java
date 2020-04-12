package by.matusevich.shapes.creator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.matusevich.shapes.creator.impl.TriangleCreatorImpl;
import by.matusevich.shapes.exception.CreatorException;
import by.matusevich.shapes.exception.EntityException;
import by.matusevich.shapes.exception.ServiceException;
import by.matusevich.shapes.exception.WareHouseException;
import by.matusevich.shapes.model.entity.Point;
import by.matusevich.shapes.model.entity.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleCreatorImplTest {
    TriangleCreator triangleCreator;
    List<String> listTriangles;

    @BeforeClass
    public void setUp() {
        triangleCreator = new TriangleCreatorImpl();
        listTriangles = new ArrayList<>();
        listTriangles.add("1 1 2 1 1 2");
    }

    @Test
    public void createTrianglesTest() throws CreatorException, EntityException, ServiceException, WareHouseException {
        List<Triangle> triangles;
        triangles = triangleCreator.createTriangles(listTriangles);

        Triangle testTriangle = new Triangle((long)1, new Point(1,1),
                new Point(2,1),
                new Point(1,2));
        Assert.assertEquals(testTriangle,triangles.get(0));
    }

    @Test(expectedExceptions = CreatorException.class)
    public void createTrianglesTestExceptionNull() throws CreatorException, EntityException, ServiceException, WareHouseException {
        List<Triangle> triangles;
        triangles = triangleCreator.createTriangles(null);
    }

}

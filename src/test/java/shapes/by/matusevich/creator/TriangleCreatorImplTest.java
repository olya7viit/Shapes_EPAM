package shapes.by.matusevich.creator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shapes.by.matusevich.creator.impl.TriangleCreatorImpl;
import shapes.by.matusevich.exception.CreatorException;
import shapes.by.matusevich.exception.EntityException;
import shapes.by.matusevich.exception.ServiceException;
import shapes.by.matusevich.exception.WareHouseException;
import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;

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

package shapes.by.matusevich.validator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shapes.by.matusevich.exception.EntityException;
import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;

public class TriangleValidatorTest {
    private Point testPoint;
    private Triangle testTriangle;
    private TriangleValidator validator;

    @BeforeClass
    public void initialisation() throws EntityException {
        testTriangle = new Triangle((long)1, new Point(1,1),
                new Point(1,5),
                new Point(5,1));

        testPoint = new Point(1,2);

        validator = new TriangleValidator();
    }

    @Test
    public void isTriangleTest(){
        boolean result;
        result = validator.isTriangle(testTriangle);
        Assert.assertTrue(result);
    }

    @Test
    public void isTriangleTestNull(){
        boolean result;
        result = validator.isTriangle(null);
        Assert.assertFalse(result);
    }

    @Test
    public void isTriangleTestPointOne() {

        boolean result;
        result = validator.isTriangle(testPoint,
                testPoint,
                testPoint);

        Assert.assertFalse(result);
    }

    @Test
    public void isTriangleTestPoint() {

        boolean result;
        result = validator.isTriangle(new Point(1,2),
                new Point(2,2),
                new Point(1,3));

        Assert.assertTrue(result);
    }

}

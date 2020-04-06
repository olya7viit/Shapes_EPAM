package shapes.by.matusevich.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shapes.by.matusevich.model.entity.EntityException;
import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.entity.TriangleFactory;
import shapes.by.matusevich.validator.Validator;

public class ValidatorTest {
    private Point testPoint;
    private Triangle testTriangle;
    private Validator validator;

    @BeforeClass
    public void initialisation() throws EntityException {
        String[] data = {"1", "1", "1", "1", "5", "5", "1"};
        testTriangle = TriangleFactory.getInstance().getTriangle(data);

        testPoint = new Point(1,2);

        validator = new Validator();
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

    @Test
    public void isDoubleTest() {

        boolean result;
        result = validator.isDouble("12");

        Assert.assertTrue(result);
    }


}

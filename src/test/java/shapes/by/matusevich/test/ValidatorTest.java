package shapes.by.matusevich.test;

import org.junit.Assert;
import org.junit.Test;
import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.validator.Validator;

public class ValidatorTest {

    @Test
    public void testValidator1() {
        Validator validator = new Validator();
        boolean result;
        result = validator.isDouble("12");

        Assert.assertTrue(result);
    }

    @Test
    public void testValidator2() {
        Validator validator = new Validator();
        boolean result;
        result = validator.isTriangle(new Point(1,2),
                new Point(2,2),
                new Point(1,3));

        Assert.assertTrue(result);
    }
}

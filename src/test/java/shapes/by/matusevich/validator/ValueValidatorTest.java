package shapes.by.matusevich.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValueValidatorTest {
    @Test
    public void isDoubleTest() {
        ValueValidator validator = new ValueValidator();

        boolean result;
        result = validator.isDouble("12");

        Assert.assertTrue(result);
    }
}

package shapes.by.matusevich.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shapes.by.matusevich.parser.ParserException;
import shapes.by.matusevich.parser.impl.TriangleParserImpl;

import java.util.ArrayList;
import java.util.List;

public class TriangleParserImplTest {
    private TriangleParserImpl parser;

    @BeforeClass
    public void initialisation() {
        parser = new TriangleParserImpl();
    }

    @Test
    public void parsTest() throws ParserException {
        List data = new ArrayList();
        data.add("1");
        data.add("1 1 2 1 1 2 1");
        data.add("1");

        List actual;
        actual = parser.pars(data);

        List expected = new ArrayList();
        expected.add("1 1 2 1 1 2 1");

        Assert.assertEquals(expected,actual);
    }

    @Test(expectedExceptions = ParserException.class)
    public void parsTestException() throws ParserException {

        List actual;
        actual = parser.pars(null);
    }

}

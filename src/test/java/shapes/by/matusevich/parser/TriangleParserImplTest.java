package shapes.by.matusevich.parser;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shapes.by.matusevich.exception.ParserException;
import shapes.by.matusevich.parser.impl.TriangleParserImpl;

import java.util.ArrayList;
import java.util.List;

public class TriangleParserImplTest {
    TriangleParser triangleParser;
    List<String> listTriangles;

    @BeforeClass
    public void setUp() {
        triangleParser = new TriangleParserImpl();

        listTriangles = new ArrayList<>();
        listTriangles.add("1 1 2 1 1 2");
        listTriangles.add("3w2 1 4 1 1 2 3");
    }

    @Test
    public void parsTriangleTest() throws ParserException {
        List<String> expectedListTriangles = new ArrayList<>();
        expectedListTriangles.add("1 1 2 1 1 2");

        List<String> actualListTriangles;
        actualListTriangles = triangleParser.parsTriangle(listTriangles);

        Assert.assertEquals(expectedListTriangles,actualListTriangles);
    }

    @Test(expectedExceptions = ParserException.class)
    public void parsTestException() throws ParserException {

        List<String> actualListTriangles;
        actualListTriangles = triangleParser.parsTriangle(null);
    }
}

package shapes.by.matusevich.test;

import org.junit.Assert;
import org.junit.Test;
import shapes.by.matusevich.dao.DaoException;
import shapes.by.matusevich.dao.TriangleDao;
import shapes.by.matusevich.dao.impl.FileTriangleDao;
import shapes.by.matusevich.model.entity.EntityException;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.entity.TriangleFactory;
import shapes.by.matusevich.parser.TriangleParser;
import shapes.by.matusevich.parser.impl.TriangleParserImpl;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    @Test
    public void testReed() {
        List<String> lines = new ArrayList<>();
        TriangleDao triangleDao = new FileTriangleDao();

        try {
            lines = triangleDao.reed("file.txt");
        } catch (DaoException e) {
            //log
        }

        String res= lines.get(0);
        Assert.assertEquals("1 1 2 1 1 2 1", res);
    }

    @Test
    public void testPars() {
        List<String> lines = new ArrayList<>();
        TriangleDao triangleDao = new FileTriangleDao();

        try {
            lines = triangleDao.reed("file.txt");
        } catch (DaoException e) {
            //log
        }

        TriangleParser parser = new TriangleParserImpl();

        List data;
        data = parser.pars(lines);

        String result =String.valueOf(data.get(0));

        Assert.assertEquals("1 1 2 1 1 2 1", result);

    }

    @Test
    public void testFactory() throws EntityException {

        final String PARAM_DELIMITER = " ";

        List<String> lines = new ArrayList<>();
        TriangleDao triangleDao = new FileTriangleDao();

        try {
            lines = triangleDao.reed("file.txt");
        } catch (DaoException e) {
            //log
        }

        TriangleParser parser = new TriangleParserImpl();

        List data;
        data = parser.pars(lines);

        String[] elements;
        elements = String.valueOf(data.get(0)).split(PARAM_DELIMITER);

        Triangle triangle;
        triangle = TriangleFactory.getInstance().getTriangle(elements);

        String[] testElements = {"1", "1", "2", "1", "1", "2", "1"};
        Triangle testTriangle;
        testTriangle = TriangleFactory.getInstance().getTriangle(testElements);

        Assert.assertEquals(testTriangle, triangle);
    }
}

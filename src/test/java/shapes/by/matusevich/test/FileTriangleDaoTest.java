package shapes.by.matusevich.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import shapes.by.matusevich.dao.DaoException;
import shapes.by.matusevich.dao.TriangleDao;
import shapes.by.matusevich.dao.impl.FileTriangleDao;

import java.util.ArrayList;
import java.util.List;

public class FileTriangleDaoTest {

    @Test
    public void reedTest() throws DaoException {
        String expected = "1 1 2 1 1 2 1";
        List<String> lines;
        TriangleDao triangleDao = new FileTriangleDao();

        lines = triangleDao.reed("src/main/resources/file.txt");

        String actual= lines.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = DaoException.class)
    public void reedTestExceptions() throws DaoException{

        List<String> lines = new ArrayList<>();
        TriangleDao triangleDao = new FileTriangleDao();

        lines = triangleDao.reed("src/main/resources/file1.txt");
    }

    @Test(expectedExceptions = DaoException.class)
    public void reedTestEmptyFile() throws DaoException{

        List<String> lines = new ArrayList<>();
        TriangleDao triangleDao = new FileTriangleDao();

        lines = triangleDao.reed("src/main/resources/test_file.txt");
    }

    @Test
    public void reedTestNull() throws DaoException{

        String expected = "1 1 2 1 1 2 1";
        List<String> lines;
        TriangleDao triangleDao = new FileTriangleDao();

        lines = triangleDao.reed(null);

        String actual= lines.get(0);
        Assert.assertEquals(expected, actual);
    }

}

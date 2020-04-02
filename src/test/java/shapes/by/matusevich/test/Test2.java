package shapes.by.matusevich.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import shapes.by.matusevich.dao.DaoException;
import shapes.by.matusevich.dao.TriangleDao;
import shapes.by.matusevich.dao.impl.FileTriangleDao;
import shapes.by.matusevich.model.entity.EntityException;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    @Test
    public void testDao() throws DaoException, EntityException {
        Logger logger = LogManager.getLogger();

        List<String> lines;
        TriangleDao triangleDao = new FileTriangleDao();

        try {
            lines = triangleDao.reed("src/main/resources/file1.txt");
            logger.log(Level.INFO,"Работа с файлом: успешно.");
        } catch (DaoException e) {
            throw new DaoException(e);
        }
    }

    @Test(expected = DaoException.class)
    public void NotFoundFileTest() throws DaoException{

        List<String> lines = new ArrayList<>();
        TriangleDao triangleDao = new FileTriangleDao();

        lines = triangleDao.reed("src/main/resources/file1.txt");
    }

    @Test(expected = DaoException.class)
    public void EmptyFileTest() throws DaoException{

        List<String> lines = new ArrayList<>();
        TriangleDao triangleDao = new FileTriangleDao();

        lines = triangleDao.reed("src/main/resources/test_file.txt");
    }
}

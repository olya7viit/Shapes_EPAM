package shapes.by.matusevich.test;

import shapes.by.matusevich.dao.TriangleDao;
import shapes.by.matusevich.dao.impl.FileTriangleDao;
import shapes.by.matusevich.model.entity.Triangle;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Test1 {
    @Test
    public void testReed() throws IOException, CloneNotSupportedException {
        List<Triangle> triangles;
        TriangleDao triangleDao = new FileTriangleDao();

        triangles = triangleDao.reed();

        long res= triangles.get(0).getId();
        Assert.assertEquals(1, res);
    }
}

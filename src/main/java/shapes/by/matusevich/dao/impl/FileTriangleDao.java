package shapes.by.matusevich.dao.impl;

import shapes.by.matusevich.dao.TriangleDao;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.validator.Validator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTriangleDao implements TriangleDao {

    private static final String FILE_NAME = "C:\\Users\\User\\IdeaProjects\\Shapes_EPAM\\src\\main\\resources\\file.txt";

    @Override
    public List<Triangle> reed() throws IOException, CloneNotSupportedException {

        List<Triangle> triangles = new ArrayList();

        File file = new File(FILE_NAME);

        FileReader fr = new FileReader(file);

        BufferedReader reader = new BufferedReader(fr);

        String line = reader.readLine();
        while (line != null) {
            Validator.checkTriangleFromFile(triangles, line);
            line = reader.readLine();
        }

        return triangles;
    }
}

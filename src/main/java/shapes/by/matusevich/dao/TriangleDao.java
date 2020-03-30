package shapes.by.matusevich.dao;

import shapes.by.matusevich.model.entity.Triangle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface TriangleDao {

    List<Triangle> reed() throws IOException, CloneNotSupportedException;
}

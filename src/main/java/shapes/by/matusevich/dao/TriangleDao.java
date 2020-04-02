package shapes.by.matusevich.dao;

import java.util.List;

public interface TriangleDao {

    List<String> reed(String fileName) throws DaoException;
}
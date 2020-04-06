package shapes.by.matusevich.dao.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shapes.by.matusevich.dao.DaoException;
import shapes.by.matusevich.dao.TriangleDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileTriangleDao implements TriangleDao {

    static Logger logger = LogManager.getLogger();

    private static final String FILE_NAME = "src/main/resources/file.txt";

    @Override
    public List<String> reed(String fileName) throws DaoException {

        List<String> lines;

        if(fileName == null){
            fileName = FILE_NAME;
        }

        try {
            lines = Files.readAllLines(Paths.get(fileName), UTF_8);

            if(lines.isEmpty()){
                logger.log(Level.ERROR, new StringBuilder().append("FILE ").append(fileName).append(" IS EMPTY").toString());
                throw new DaoException();
            }

            logger.log(Level.INFO, "READING THE FILE SUCCESSFULLY: " + fileName);

        } catch (IOException e) {
            logger.log(Level.FATAL, new StringBuilder().append("FILE ").append(fileName).append(" DOES NOT EXIST").toString());
            throw new DaoException("Errors during reading", e);
        }

        return lines;
    }

}

package shapes.by.matusevich.reader.impl;

import org.apache.logging.log4j.LogManager;
import shapes.by.matusevich.exception.ReaderException;
import shapes.by.matusevich.reader.TriangleReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;

public class TriangleReaderImpl implements TriangleReader {
    private static final String FILE_NAME = "src/main/resources/file.txt";
    static Logger logger = LogManager.getLogger();

    @Override
    public List<String> reedAllData(String fileName) throws ReaderException {
        List<String> lines;

        if(fileName == null){
            fileName = FILE_NAME;
        }

        try(FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
            lines = bufferedReader.lines()
                    .collect(Collectors.toList());
            if(lines.isEmpty()){
                logger.log(Level.FATAL, "file: " + fileName + " is empty");
                throw  new ReaderException("error working with the file");
            }
        }
        catch (IOException e){
            logger.log(Level.FATAL, "error working with the file: " + fileName, e);
            throw  new ReaderException("error working with the file", e);
        }
        return lines;
    }
}

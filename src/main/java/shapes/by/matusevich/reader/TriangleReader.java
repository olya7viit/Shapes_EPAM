package shapes.by.matusevich.reader;

import shapes.by.matusevich.exception.ReaderException;

import java.util.List;

public interface TriangleReader {
    List<String>  reedAllData(String fileName) throws ReaderException;
}

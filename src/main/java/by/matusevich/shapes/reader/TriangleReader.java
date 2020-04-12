package by.matusevich.shapes.reader;

import by.matusevich.shapes.exception.ReaderException;

import java.util.List;

public interface TriangleReader {
    List<String>  reedAllData(String fileName) throws ReaderException;
}

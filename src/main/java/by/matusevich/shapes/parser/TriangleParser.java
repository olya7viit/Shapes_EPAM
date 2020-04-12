package by.matusevich.shapes.parser;

import by.matusevich.shapes.exception.ParserException;

import java.util.List;

public interface TriangleParser {
    List parsTriangle(List<String> lines) throws ParserException;
}

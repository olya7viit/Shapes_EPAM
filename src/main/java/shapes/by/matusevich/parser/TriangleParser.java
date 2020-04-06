package shapes.by.matusevich.parser;

import shapes.by.matusevich.exception.ParserException;

import java.util.List;

public interface TriangleParser {
    List parsTriangle(List<String> lines) throws ParserException;
}

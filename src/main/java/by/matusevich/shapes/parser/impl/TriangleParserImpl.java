package by.matusevich.shapes.parser.impl;

import by.matusevich.shapes.exception.ParserException;
import by.matusevich.shapes.parser.TriangleParser;
import by.matusevich.shapes.validator.TriangleValidator;;

import java.util.ArrayList;
import java.util.List;

public class TriangleParserImpl implements TriangleParser {

    private final static int COUNT_TRIANGLE_ELEMENTS = 6;

    @Override
    public List parsTriangle(List<String> listTriangles) throws ParserException {
        if (listTriangles == null) {
            throw new ParserException("list is null");
        }

        TriangleValidator validator = new TriangleValidator();
        List<String> correctDataTriangles = new ArrayList<>();

        for (String listTriangle : listTriangles) {
            if (validator.isCorrectData(listTriangle, COUNT_TRIANGLE_ELEMENTS)) {
                correctDataTriangles.add(listTriangle);
            }
        }

        return correctDataTriangles;
    }
}

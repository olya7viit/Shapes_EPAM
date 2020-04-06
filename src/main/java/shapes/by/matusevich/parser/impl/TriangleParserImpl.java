package shapes.by.matusevich.parser.impl;

import shapes.by.matusevich.exception.ParserException;
import shapes.by.matusevich.parser.TriangleParser;
import shapes.by.matusevich.validator.TriangleValidator;;

import java.util.ArrayList;
import java.util.List;

public class TriangleParserImpl implements TriangleParser {
    private static final int COUNT_TRIANGLE_ELEMENTS = 6;

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

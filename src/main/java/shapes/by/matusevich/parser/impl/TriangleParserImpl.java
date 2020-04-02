package shapes.by.matusevich.parser.impl;

import shapes.by.matusevich.parser.TriangleParser;
import shapes.by.matusevich.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class TriangleParserImpl implements TriangleParser {

    private static final int COUNT_ELEMENT = 7;

    @Override
    public List pars(List<String> lines) {

        Validator validator = new Validator();
        List correctData = new ArrayList();

        for (int i=0;i<lines.size();i++){
            if(validator.isCorrectData(lines.get(i), COUNT_ELEMENT)){
                correctData.add(lines.get(i));
            }
        }

        return correctData;
    }
}

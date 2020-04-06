package shapes.by.matusevich.parser.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shapes.by.matusevich.parser.ParserException;
import shapes.by.matusevich.parser.TriangleParser;
import shapes.by.matusevich.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class TriangleParserImpl implements TriangleParser {
    static Logger logger = LogManager.getLogger();
    private static final int COUNT_ELEMENT = 7;

    @Override
    public List pars(List<String> lines) throws ParserException {

        if(lines == null){
            logger.log(Level.ERROR, "THE VALUE IS NULL");
            throw new ParserException("INCORRECT DATA");
        }

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

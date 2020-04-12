package by.matusevich.shapes.validator;

public class ValueValidator {
    private final static String REGEX_DOUBLE_NUMBER = "^\\d*[.,]?\\d+$";

    public boolean isDouble(String value) {

        if(value == null){
            return false;
        }
        return value.matches(REGEX_DOUBLE_NUMBER);
    }
}

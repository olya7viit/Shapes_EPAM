package shapes.by.matusevich.validator;

public class ValueValidator {
    private static final String REGEX_DOUBLE_NUMBER = "^\\d*[.,]?\\d+$";

    public boolean isDouble(String value) {

        if(value == null){
            return false;
        }
        return value.matches(REGEX_DOUBLE_NUMBER);
    }
}

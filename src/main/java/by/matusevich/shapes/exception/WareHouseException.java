package by.matusevich.shapes.exception;

public class WareHouseException extends Exception {
    private static final long serialVersionUID = 2l;

    public WareHouseException() {
        super();
    }

    public WareHouseException(String message) {
        super(message);
    }

    public WareHouseException(Exception e) {
        super(e);
    }

    public WareHouseException(String message, Exception e) {
        super(message, e);
    }


}
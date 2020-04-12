package by.matusevich.shapes.exception;

public class ReaderException extends Exception {

    private static final long serialVersionUID = 1L;

    public ReaderException() {
        super();
    }

    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(Exception e) {
        super(e);
    }

    public ReaderException(String message, Exception e) {
        super(message, e);
    }
}

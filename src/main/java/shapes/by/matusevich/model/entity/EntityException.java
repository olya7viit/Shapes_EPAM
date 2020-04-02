package shapes.by.matusevich.model.entity;

public class EntityException extends Exception {
    private static final long serialVersionUID = 2l;

    public EntityException() {
        super();
    }

    public EntityException(String message) {
        super(message);
    }

    public EntityException(Exception e) {
        super(e);
    }

    public EntityException(String message, Exception e) {
        super(message, e);
    }


}
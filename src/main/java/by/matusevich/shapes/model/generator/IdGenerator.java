package by.matusevich.shapes.model.generator;

public class IdGenerator {

    private final static long MIN_ID = 1;
    private final static long MAX_ID = 100_000;
    private static long counter;

    private IdGenerator(){}

    public static long generateId() {
        counter++;
        if (MIN_ID + counter >= MAX_ID) {
            counter = 0;
        }
        return counter;
    }

    public static void setId(long id) {
        counter = id;
    }
}

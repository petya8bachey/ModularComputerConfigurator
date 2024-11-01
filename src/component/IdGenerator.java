package component;

public enum IdGenerator {
    INSTANCE;
    private static long id = 0;
    public long generateId() {
        return id++;
    }
}

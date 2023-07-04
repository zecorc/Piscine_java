public class UserIdsGenerator {
    private int lastGeneratedId = 0;
    private static UserIdsGenerator instance;

    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        lastGeneratedId++;
        return lastGeneratedId;
    }
}

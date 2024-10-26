package liamohara.model;

public class Dictionary {

    private static Dictionary instance;

    private Dictionary() {}

    public static Dictionary getInstance() {
        if (instance == null) {
            instance = new Dictionary();
        }
        return instance;
    }

}

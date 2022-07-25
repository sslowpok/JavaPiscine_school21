package ex03;

public class UserIdsGenerator {

    private Integer id = 0;

    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();

    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        return INSTANCE;
    }

    public Integer generateId() {
        return id++;
    }

}

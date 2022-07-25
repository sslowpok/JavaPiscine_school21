package ex02;

public class User {

    private final Integer id;
    private String name;
    private Integer balance;

    public User(String name, Integer balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        setName(name);
        setBalance(balance);
    }

    public User() {
        this.id = UserIdsGenerator.getInstance().generateId();
        setName("default");
        setBalance(0);
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBalance(Integer balance) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public Integer getBalance() {
        return this.balance;
    }

}

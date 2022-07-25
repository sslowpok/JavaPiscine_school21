package ex00;

public class User {

    private Integer id;
    private String name;
    private Integer balance;

    public User(Integer id, String name, Integer balance) {
        setId(id);
        setName(name);
        setBalance(balance);
    }

    public User(String name, Integer balance) {
        setId(0);
        setName(name);
        setBalance(balance);
    }

    public User() {
        setId(0);
        setName("default");
        setBalance(0);
    }

    public void setId(Integer id) {
        this.id = id;
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

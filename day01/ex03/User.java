package ex03;

public class User {

    private final Integer id;
    private String name;
    private Integer balance;
    private TransactionsList transactions;

    public User(String name, Integer balance, TransactionsList transactions) {
        this.id = UserIdsGenerator.getInstance().generateId();
        setName(name);
        setBalance(balance);
        setTransactions(transactions);
    }

    public User() {
        this.id = UserIdsGenerator.getInstance().generateId();
        setName("default");
        setBalance(0);
        setTransactions(null);
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

    public void setTransactions(TransactionsList transactions) {
        this.transactions = transactions;
    }

    public TransactionsList getTransactions() {
        return transactions;
    }
}

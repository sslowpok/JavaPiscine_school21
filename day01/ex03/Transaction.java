package ex03;

import java.util.UUID;

public class Transaction {

    private final UUID id;
    private User recipient;
    private User sender;
    private String category;
    private Integer amount;

    public Transaction(User recipient, User sender, String category, Integer amount) {
        this.id = UUID.randomUUID();
        setRecipient(recipient);
        setSender(sender);
        setCategory(category);
        setAmount(amount);
    }

    public UUID getId() {
        return id;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getSender() {
        return sender;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setAmount(Integer amount) {
        if ((category.equals("INCOME") && amount > 0) ||
        (category.equals("OUTCOME") && amount < 0)) {
            this.amount = amount;
        }
    }

    public Integer getAmount() {
        return amount;
    }
}

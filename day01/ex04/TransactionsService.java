package ex04;

import java.util.UUID;

public class TransactionsService implements TransactionsServiceInterface {

    public int num = 0;
    private UsersArrayList usersList;
    private TransactionsLinkedList unpairedTransactions = new TransactionsLinkedList();

    public TransactionsService(UsersArrayList usersList) {
        setUsersList(usersList);
    }

    public TransactionsService() {
        usersList = new UsersArrayList();
    }

    public void setUsersList(UsersArrayList usersList) {
        this.usersList = usersList;
    }

    public UsersArrayList getUsersList() {
        return usersList;
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }

    public Integer getBalance(Integer id) {
        return usersList.getUserById(id).getBalance();
    }

    public User getUserByIndex(Integer index) {
        return usersList.getUserByIndex(index);
    }

    public void performTransfer(Integer senderId, Integer recipientId, Integer amount) {

        User recipient = usersList.getUserById(recipientId);
        User sender = usersList.getUserById(senderId);

        if (amount > sender.getBalance()) {
            throw new IllegalTransactionException("User " + senderId + "'s balance is less than amount they want to send. Declined");
        }

        int tmp = ++num;
        UUID transactionId = new UUID(amount, tmp);

        Transaction income = new Transaction(transactionId, sender, recipient, "INCOME", amount);
        Transaction outcome = new Transaction(transactionId, sender, recipient, "OUTCOME", -amount);


        recipient.getTransactions().addTransaction(income);
        sender.getTransactions().addTransaction(outcome);

        recipient.setBalance(recipient.getBalance() + amount);
        sender.setBalance(sender.getBalance() - amount);

    }

    @Override
    public Transaction[] getUserTransactions(Integer id) {
        return usersList.getUserById(id).getTransactions().toArray();
    }

    @Override
    public void removeUserTransactionById(Integer userId, UUID transactionId) {

        if (unpairedTransactions.isPresent(transactionId)) {
            unpairedTransactions.removeTransactionById(transactionId);
        } else {
            unpairedTransactions.addTransaction(usersList.getUserById(userId)
                    .getTransactions()
                    .getTransactionById(transactionId));
        }

        usersList.getUserById(userId)
                .getTransactions()
                .removeTransactionById(transactionId);

    }

    @Override
    public Transaction[] checkTransaction() {
        return unpairedTransactions.toArray();
    }
}

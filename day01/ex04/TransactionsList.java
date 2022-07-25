package ex04;

import java.util.UUID;

public interface TransactionsList {

    void addTransaction(Transaction newTransaction);
    void removeTransactionById(UUID id);
    Transaction[] toArray();
    boolean isPresent(UUID id);
    Transaction getTransactionById(UUID id);

}

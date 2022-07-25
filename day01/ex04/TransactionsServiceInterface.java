package ex04;

import java.util.UUID;

public interface TransactionsServiceInterface {

    Transaction[] getUserTransactions(Integer id);
    void removeUserTransactionById(Integer userId, UUID transactionId);
    Transaction[] checkTransaction();

}

import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeTransaction(UUID transactionId) throws TransactionNotFoundException;
    Transaction[] toArray();
}

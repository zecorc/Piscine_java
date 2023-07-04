public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeTransaction(String transactionId) throws TransactionNotFoundException;
    Transaction[] toArray();
}

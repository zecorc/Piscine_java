import java.util.UUID;

public class TransactionsService {
    private UserList userList;

    public TransactionsService() {
        this.userList = new UsersArrayList();
    }

    public void addUser(String username, double initialBalance) {
        User user = new User(username, initialBalance);
        userList.addUser(user);
    }

    public double getUserBalance(String username) throws UserNotFoundException {
        User user = userList.getUserByName(username);
        return user.getBalance();
    }

    public User getUserByName(String username) throws UserNotFoundException {
        User user = userList.getUserByName(username);
        return user;
    }

    public void performTransfer(int senderId, int recipientId, double transferAmount)
            throws IllegalTransactionException, UserNotFoundException {
        User sender = userList.getUserById(senderId);
        User recipient = userList.getUserById(recipientId);

        if (transferAmount > sender.getBalance()) {
            throw new IllegalTransactionException("Insufficient balance for transfer");
        }

        Transaction debitTransaction = new Transaction(recipient, sender, "DEBIT", transferAmount);
        Transaction creditTransaction = new Transaction(recipient, sender, "CREDIT", transferAmount);
        creditTransaction.setPairedTransactionId(debitTransaction.getId());
        debitTransaction.setPairedTransactionId(creditTransaction.getId());

        sender.addTransaction(debitTransaction);
        recipient.addTransaction(creditTransaction);
    }

    public Transaction[] getUserTransfers(int id) throws UserNotFoundException {
        User user = userList.getUserById(id);
        return user.getTransactionsArray();
    }

    public void removeTransaction(int id, UUID transactionId) throws UserNotFoundException, TransactionNotFoundException {
        User user = userList.getUserById(id);
        user.removeTransaction(transactionId);
    }

    public Transaction[] getUnpairedTransactions() {
        int unpairedCount = 0;

        for (int i = 0; i < userList.getNumberOfUsers(); i++) {
            try {
                User user = userList.getUserByIndex(i);
                unpairedCount += user.getUnpairedTransactionsCount();
            } catch (UserNotFoundException e) {

            }
        }

        Transaction[] unpairedTransactions = new Transaction[unpairedCount];
        int index = 0;

        for (int i = 0; i < userList.getNumberOfUsers(); i++) {
            try {
                User user = userList.getUserByIndex(i);
                Transaction[] userUnpairedTransactions = user.getUnpairedTransactionsArray();
                for (int j = 0; j < user.getUnpairedTransactionsCount(); j++) {
                    unpairedTransactions[index++] = userUnpairedTransactions[j];
                }
            } catch (UserNotFoundException e) {

            }
        }

        return unpairedTransactions;
    }
}

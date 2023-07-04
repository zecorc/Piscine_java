public class User {
    private int id;
    private String name;
    private double balance;
    private TransactionsList transactions;

    public User(String name, double balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.transactions = new TransactionsLinkedList();
        setBalance(balance);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Error: Balance cannot be negative.");
        } else {
            this.balance = balance;
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.addTransaction(transaction);
    }

    public void removeTransaction(String transactionId) throws TransactionNotFoundException {
        transactions.removeTransaction(transactionId);
    }

    public void printTransactions() {
        Transaction[] transactionsArray = transactions.toArray();
        for (Transaction transaction : transactionsArray) {
            System.out.println(transaction);
        }
    }

    @Override
    public String toString() {
        return "User [identifier=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}

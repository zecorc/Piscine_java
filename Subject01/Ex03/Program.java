import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("John", 1000.0);
        User user2 = new User("Alice", 800.0);

        Transaction t1 = new Transaction(user2, user1, "Payment", 100.0);
        Transaction t2 = new Transaction(user1, user2, "Transfer", 200.0);
        Transaction t3 = new Transaction(user2, user1, "Payment", 300.0);

        user1.addTransaction(t1);
        user1.addTransaction(t2);
        user1.addTransaction(t3);

        System.out.println("Before:");
        user1.printTransactions();
        System.out.println();
        System.out.println("after:");

        try {
            user1.removeTransaction(t2.getIdentifier().toString());
            user1.printTransactions();
            user1.removeTransaction(UUID.randomUUID().toString());
        } catch (TransactionNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
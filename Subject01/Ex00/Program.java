public class Program {
    public static void main(String[] args) {
        User user1 = new User(1, "zio", 1000.0);
        User user2 = new User(2, "pera", 500.0);

        Transaction transaction = new Transaction(user1, user2, "debits", 200.0);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(transaction);
    }
}

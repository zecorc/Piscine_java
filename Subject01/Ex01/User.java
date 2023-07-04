public class User {
    private int id;
    private String name;
    private double balance;

    public User(String name, double balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
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

    @Override
    public String toString() {
        return "User [identifier=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}

public class Program {
    public static void main(String[] args) {
        UserList userList = new UsersArrayList();

        User user1 = new User("John", 1000.0);
        User user2 = new User("Alice", 500.0);
        User user3 = new User("Bob", 750.0);

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);

        try {
            System.out.println("User at index 0: " + userList.getUserByIndex(0));
            System.out.println("User with ID 2: " + userList.getUserById(2));
            System.out.println("Number of users: " + userList.getNumberOfUsers());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}


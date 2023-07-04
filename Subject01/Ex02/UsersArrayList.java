public class UsersArrayList implements UserList {
    private static final int DEFAULT_SIZE = 10;
    private User[] users;
    private int size;

    public UsersArrayList() {
        this.users = new User[DEFAULT_SIZE];
        this.size = 0;
    }

    private void resizeArray() {
        int newSize = users.length + users.length / 2;
        User[] newArray = new User[newSize];
        System.arraycopy(users, 0, newArray, 0, users.length);
        users = newArray;
    }

    @Override
    public void addUser(User user) {
        if (size == users.length) {
            resizeArray();
        }
        users[size] = user;
        size++;
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("User with ID " + id + " not found.");
    }

    @Override
    public User getUserByIndex(int index) throws UserNotFoundException {
        if (index >= 0 && index < size) {
            return users[index];
        }
        throw new UserNotFoundException("User at index " + index + " not found.");
    }

    @Override
    public int getNumberOfUsers() {
        return size;
    }
}

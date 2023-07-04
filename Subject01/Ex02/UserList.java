public interface UserList {
    void addUser(User user);
    User getUserById(int id) throws UserNotFoundException;
    User getUserByIndex(int index) throws UserNotFoundException;
    int getNumberOfUsers();
}
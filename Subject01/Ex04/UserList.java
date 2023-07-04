public interface UserList {
    void addUser(User user);
    User getUserById(int id) throws UserNotFoundException;
    User getUserByName(String Name) throws UserNotFoundException;
    User getUserByIndex(int index) throws UserNotFoundException;
    int getNumberOfUsers();
}
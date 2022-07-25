package ex04;

public class UsersArrayList implements UsersList {

    User[] userList = new User[10];
    private Integer currentLength = 0;

    public Integer getCurrentLength() {
        return currentLength;
    }

    @Override
    public void addUser(User newUser) {

        if (currentLength < userList.length) {
            userList[currentLength] = newUser;
            currentLength++;
        } else {
            User[] newUserList = new User[(int) (userList.length * 1.5)];
            for (int i = 0; i < userList.length; i++) {
                newUserList[i] = userList[i];
            }
            newUserList[userList.length] = newUser;
            userList = newUserList;
            currentLength++;
        }

    }

    @Override
    public User getUserById(Integer id) {

        for (int i = 0; i < currentLength; i++) {
            if (userList[i].getId() == id) {
                return userList[i];
            }
        }
        throw new UserNotFoundException("User with id " + id + " not found.");
    }

    @Override
    public User getUserByIndex(Integer index) {

        for (int i = 0; i < currentLength; i++) {
            if (i == index) {
                return userList[i];
            }
        }
        throw new UserNotFoundException("User with index " + index + " not found.");
    }

    @Override
    public Integer countUsers() {

        int count;

        for (count = 0; count < userList.length; count++) {
            if (userList[count] == null) {
                break;
            }
        }
        return count;
    }

    public Integer getLength() {
        return this.currentLength;
    }

    public Integer getCapacity() {
        return this.userList.length;
    }

}

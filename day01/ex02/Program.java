package ex02;

public class Program {

    public static void main(String[] args) {

        User mike = new User("Mike", 1000);
        User tom = new User("Tom", 2000);
        User john = new User("John", 3000);
        User johan = new User("Johan", 4000);

        System.out.println("User 1:");
        System.out.println("Username: " + mike.getName());
        System.out.println("Id: " + mike.getId());
        System.out.println("Balance: " + mike.getBalance());

        System.out.println();

        System.out.println("User 2:");
        System.out.println("Username: " + tom.getName());
        System.out.println("Id: " + tom.getId());
        System.out.println("Balance: " + tom.getBalance());

        System.out.println();

        System.out.println("User 3:");
        System.out.println("Username: " + john.getName());
        System.out.println("Id: " + john.getId());
        System.out.println("Balance: " + john.getBalance());

        System.out.println();

        System.out.println("User 4:");
        System.out.println("Username: " + johan.getName());
        System.out.println("Id: " + johan.getId());
        System.out.println("Balance: " + johan.getBalance());

        System.out.println();

        UsersArrayList usersArrayList = new UsersArrayList();

        usersArrayList.addUser(mike);
        usersArrayList.addUser(tom);
        usersArrayList.addUser(john);
        usersArrayList.addUser(johan);

        System.out.println("TESTS");
        System.out.println("Added 4 users to userList.");
        System.out.println("User with id 0 is " + usersArrayList.getUserById(0).getName());
        System.out.println("User with id 1 is " + usersArrayList.getUserById(1).getName());
        System.out.println("User with id 2 is " + usersArrayList.getUserById(2).getName());
        System.out.println("User with id 3 is " + usersArrayList.getUserById(3).getName());
        System.out.println("---------------------");


        System.out.println("User with index 0 is " + usersArrayList.getUserByIndex(0).getName());
        System.out.println("User with index 1 is " + usersArrayList.getUserByIndex(1).getName());
        System.out.println("User with index 2 is " + usersArrayList.getUserByIndex(2).getName());
        System.out.println("User with index 3 is " + usersArrayList.getUserByIndex(3).getName());
        System.out.println("---------------------");
        System.out.println("Total amount of users in the list is: " + usersArrayList.countUsers());
        System.out.println("ArrayList length is " + usersArrayList.getLength());
        System.out.println("Arraylist capacity is " + usersArrayList.getCapacity());

    }

}

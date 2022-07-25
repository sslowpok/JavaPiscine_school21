package ex01;

public class Program {

    public static void main(String[] args) {

        User mike = new User("Mike", 1000);
        User tom = new User("Tom", 2000);
        User john = new User("John", 3000);

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

    }

}

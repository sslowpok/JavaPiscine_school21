package ex04;

public class Program {

    public static void main(String[] args) {

        User mike = new User("Mike", 1000, null);
        User tom = new User("Tom", 2000, null);
        User john = new User("John", 3000, null);
        User johan = new User("Johan", 4000, null);

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

//        usersArrayList.addUser(mike);
//        usersArrayList.addUser(tom);
//        usersArrayList.addUser(john);
//        usersArrayList.addUser(johan);

        System.out.println("TRANSACTIONS SERVICE TESTS");

        TransactionsService service = new TransactionsService();

        service.addUser(mike);
        service.addUser(tom);
        service.addUser(john);
        service.addUser(johan);

        System.out.println("Added " + service.getUsersList().countUsers() + " users:");
        UsersArrayList usersList = service.getUsersList();
        for (int i = 0; i < usersList.countUsers(); i++) {
            System.out.println("Name: " + usersList.getUserByIndex(i).getName() + " " +
                    "Id: " + usersList.getUserByIndex(i).getId() + " " +
                    "Balance: " + usersList.getUserByIndex(i).getBalance());
        }


        System.out.println("------------------");
        System.out.println("Transaction:");
        System.out.println("From: " + service.getUsersList().getUserById(1).getName());
        System.out.println("To: " + service.getUsersList().getUserById(2).getName());
        System.out.println("Amount: 500");
        System.out.println("Check if transaction is correct:");
        System.out.println("Sender's balance before transaction: " + service.getUsersList().getUserById(1).getBalance());
        System.out.println("Recipient's balance before transaction: " + service.getUsersList().getUserById(2).getBalance());

        service.performTransfer(1, 2, 500);

        System.out.println("Sender's balance after transaction: " + service.getUsersList().getUserById(1).getBalance());
        System.out.println("Recipient's balance after transaction: " + service.getUsersList().getUserById(2).getBalance());

        System.out.println("Checking if transaction is correct:");
        System.out.println("List of sender's transactions:");
        Transaction[] arr1 = service.getUserTransactions(1);
        for (Transaction transaction : arr1) {
            System.out.println(transaction.getId());
        }
        Transaction[] arr2 = service.getUserTransactions(2);
        System.out.println("List of recipient's transactions:");
        for (Transaction transaction : arr2) {
            System.out.println(transaction.getId());
        }

        System.out.println("------------------");
        System.out.println("Transaction:");
        System.out.println("From: " + service.getUsersList().getUserById(2).getName());
        System.out.println("To: " + service.getUsersList().getUserById(3).getName());
        System.out.println("Amount: 500");
        System.out.println("Check if transaction is correct:");
        System.out.println("Sender's balance before transaction: " + service.getUsersList().getUserById(2).getBalance());
        System.out.println("Recipient's balance before transaction: " + service.getUsersList().getUserById(3).getBalance());

        service.performTransfer(2, 3, 500);

        System.out.println("Sender's balance after transaction: " + service.getUsersList().getUserById(2).getBalance());
        System.out.println("Recipient's balance after transaction: " + service.getUsersList().getUserById(3).getBalance());

        System.out.println("List of sender's transactions:");
        Transaction[] arr3 = service.getUserTransactions(2);
        for (Transaction transaction : arr3) {
            System.out.println(transaction.getId());
        }
        Transaction[] arr4 = service.getUserTransactions(3);
        System.out.println("List of recipient's transactions:");
        for (Transaction transaction : arr4) {
            System.out.println(transaction.getId());
        }

        System.out.println("---------------------");
        System.out.println("Removing 0 transaction from user 2");
        System.out.println("List of 0's transactions before removal:");
        for (Transaction transaction : arr3) {
            System.out.println(transaction.getId());
        }

        service.removeUserTransactionById(2, service.getUsersList().getUserById(2).getTransactions().toArray()[0].getId());
        System.out.println("List of 0's transactions after removal:");
        arr3 = service.getUserTransactions(2);
        for (Transaction transaction : arr3) {
            System.out.println(transaction.getId());
        }



    }

}

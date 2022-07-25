package ex00;

public class Program {

    public static void main(String[] args) {

        User mike = new User(0, "Mike", 1000);
        User tom = new User(1, "Tom", 2000);

        Transaction tr1 = new Transaction(tom, mike, "INCOME", 500);
        Transaction tr2 = new Transaction(mike, tom, "OUTCOME", -500);

        System.out.println("User 1:");
        System.out.println("Username: " + mike.getName());
        System.out.println("id: " + mike.getId());
        System.out.println("balance: " + mike.getBalance());

        System.out.println();

        System.out.println("User 2:");
        System.out.println("Username: " + tom.getName());
        System.out.println("id: " + tom.getId());
        System.out.println("balance: " + tom.getBalance());

        System.out.println();

        System.out.println("Transaction 1:");
        System.out.println("id: " + tr1.getId());
        System.out.println("Sender:" + tr1.getSender().getName());
        System.out.println("Recipient: " + tr1.getRecipient().getName());
        System.out.println("Category: " + tr1.getCategory());
        System.out.println("Amount: " + tr1.getAmount());

        System.out.println();

        System.out.println("Transaction 2:");
        System.out.println("id: " + tr2.getId());
        System.out.println("Sender:" + tr2.getSender().getName());
        System.out.println("Recipient: " + tr2.getRecipient().getName());
        System.out.println("Category: " + tr2.getCategory());
        System.out.println("Amount: " + tr2.getAmount());

    }

}

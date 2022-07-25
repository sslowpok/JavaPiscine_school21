package ex03;

public class Node {

    Transaction item;
    Node next;
    Node prev;

    public Node(Node prev, Transaction item, Node next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    public Node(Node prev, Transaction item) {
        this.item = item;
        this.prev = prev;
        this.next = null;
    }

    public Node(Transaction item) {
        this.item = item;
        this.prev = null;
        this.next = null;
    }

}

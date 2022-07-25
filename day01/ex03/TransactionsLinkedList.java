package ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private Node head = null;
    private Node tail = null;
    private Integer length = 0;


    @Override
    public void addTransaction(Transaction newTransaction) {

        if (head == null) {
            head = new Node(null, newTransaction, null);
        } else if (tail == null) {
            tail = new Node(head, newTransaction, null);
            head.next = tail;
        } else {
            tail.next = new Node(tail, newTransaction, null);
            tail = tail.next;
        }
        length++;
    }

    @Override
    public void removeTransactionById(UUID id) {

        if (head.item.getId() == id) {
            head = head.next;
            head.prev = null;
            length--;
        } else if (tail.item.getId() == id) {
            tail = tail.prev;
            tail.next = null;
            length--;
        } else {
            Node temp = head;

            while (temp != tail) {

                if (temp.item.getId() == id) {
                    Node prev = temp.prev;
                    Node next = temp.next;

                    prev.next = next;
                    next.prev = prev;
                    break;
                }
                temp = temp.next;
            }
            if (temp == tail) {
                throw new TransactionNotFoundException("Transaction with id " + id + " not found");
            }
            length--;
        }

    }

    @Override
    public Transaction[] toArray() {

        Transaction[] array = new Transaction[length];
        Node temp = head;

        for (int i = 0; i < length; i++) {
            array[i] = temp.item;
            temp = temp.next;
        }

        return array;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.item.getId());
            temp = temp.next;
        }
    }

}

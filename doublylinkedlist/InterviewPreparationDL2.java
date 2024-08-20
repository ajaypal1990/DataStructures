package com.ajay.concepts.doublylinkedlist;

public class InterviewPreparationDL2 {
    public static void main(String[] args) {
        DoublyLinkedList1 doublyLinkedList1=new DoublyLinkedList1();
        doublyLinkedList1.insertLast(5);
        doublyLinkedList1.insertLast(10);
        doublyLinkedList1.insertLast(15);
        doublyLinkedList1.insertLast(20);

        doublyLinkedList1.printForward();

        doublyLinkedList1.printBackward();

        doublyLinkedList1.insertFirst(1);

        doublyLinkedList1.printForward();
        doublyLinkedList1.deleteFirst();
        doublyLinkedList1.printForward();
        doublyLinkedList1.deleteLast();
        doublyLinkedList1.printForward();

    }
}

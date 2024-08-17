package com.ajay.concepts.doublylinkedlist;

public class InterviewPreparationSeriesDL1 {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList=new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        doublyLinkedList.insertLast(10);
        doublyLinkedList.insertLast(20);
        doublyLinkedList.insertLast(30);
        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackward();

        doublyLinkedList.insertAtStart(0);
        doublyLinkedList.displayForward();

        doublyLinkedList.insertAtEnd(40);
        doublyLinkedList.displayForward();

    }
}

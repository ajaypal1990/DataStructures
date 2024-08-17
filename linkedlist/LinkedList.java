package com.ajay.concepts.linkedlist;

public class LinkedList<E> {

    public ListNode<E> head;
    public static class ListNode<E>{
        public E data;
        public ListNode<E> next;

        public ListNode(E data){
            this.data=data;
            this.next=null;
        }

        public E getData() {
            return data;
        }

        public void setNext(ListNode<E> next) {
            this.next = next;
        }

        public ListNode<E> getNext() {
            return next;
        }

        public String toString() {
            return String.valueOf(this.data);  // assuming your ListNode has a field named 'value'
        }
    }
}

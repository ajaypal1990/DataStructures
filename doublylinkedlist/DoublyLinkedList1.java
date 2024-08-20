package com.ajay.concepts.doublylinkedlist;

import com.ajay.concepts.datastructutes.LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList1<E> {
    private ListNode<E> head;

    private ListNode<E> tail;

    private int length;

    private boolean isEmpty(){
        return length==0;
    }

    public DoublyLinkedList1(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    public int getLength() {
        return length;
    }

    public void printForward(){
        ListNode<E> temp = head;
        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void insertLast(E value) {
        ListNode<E> newNode=new ListNode<E>(value);
        if(isEmpty()){
            head=newNode;
        }else {
           tail.next=newNode;
        }
        newNode.previous=tail;
        tail=newNode;
        length++;
    }

    public void printBackward() {

        if(tail == null){
            return;
        }
        ListNode<E> temp= tail;
        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(E value) {
        ListNode<E> newNode=new ListNode<>(value);
        if(isEmpty()){
            tail = tail.next;
        }else {
            head.previous=newNode;
        }
        newNode.next=head;
        head=newNode;
    }

    public void deleteFirst() {

        if(isEmpty()){
            throw new NoSuchElementException("No such element found");
        }

        ListNode<E> tempNode = head;
        if(head == tail){
            tail=null;
        }else {
            head.next.previous=null;
        }
        head=head.next;
        tempNode.next=null;
        System.out.println("Deleted Node is: "+tempNode);
    }

    public void deleteLast() {
        if(isEmpty()){
            throw new NoSuchElementException("no element to delete");
        }
        ListNode temp= tail;
        if(head == tail){
            head = null;
        }else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;

    }


    public static class ListNode<E>{
        private E data;
        private ListNode<E> next;

        private ListNode<E> previous;

        public ListNode(E data){
            this.data=data;
        }
        public void toString(E data){
            this.data=data;
        }
    }
}

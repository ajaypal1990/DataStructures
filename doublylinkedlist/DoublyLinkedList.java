package com.ajay.concepts.doublylinkedlist;

import com.ajay.concepts.linkedlist.LinkedList;

public class DoublyLinkedList<E> {

    private ListNode<E> head;
    private ListNode<E> tail;
    private int length;


    public static class ListNode<E>{
        private E data;
        private ListNode next;
        private ListNode previous;

        private ListNode(E data){
            this.data=data;
        }

    }

    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }
    public Boolean isEmpty(){
        return length==0;
    }

    public int getLength() {
        return length;
    }

    public void displayForward(){
        if(head == null){
            return;
        }
        ListNode temp=head;

        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        if (tail == null){
            return;
        }
        ListNode temp = tail;
        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.previous;
        }
        System.out.println("null");
    }

    public void insertLast(int value){
        ListNode newNode=new ListNode(value);
        if (isEmpty()){
            head = newNode;
        }else {
            tail.next=newNode;
        }
        newNode.previous=tail;
        tail = newNode;
        length++;
    }

    public void insertAtStart(int value){
        ListNode newNode=new ListNode(value);
        if(isEmpty()){
            tail=newNode;
        }else {
            head.previous=newNode;
        }
        newNode.next=head;
        head=newNode;
        length++;
    }
    public void insertAtEnd(int value){
        ListNode listNode=new ListNode(value);
        if(isEmpty()){
            head.next=listNode;
        }else {
            tail.next=listNode;
            listNode.previous=tail;
        }
        tail=listNode;
    }
}

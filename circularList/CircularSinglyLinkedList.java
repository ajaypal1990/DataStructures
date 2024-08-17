package com.ajay.concepts.circularList;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    public CircularSinglyLinkedList(){
        last = null;
        length=0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty(){
        return length ==0;
    }

    public void createCircularLinkedList(){
        ListNode first=new ListNode(5);
        ListNode second=new ListNode(10);
        ListNode third=new ListNode(15);
        ListNode fourth=new ListNode(20);

        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=first;

        last=fourth;
    }

    public void displayCircularLinkedList(){
        if(last == null){
            return;
        }

        ListNode first = last.next;
        while (first!=last){
            System.out.print(first.data+"->");
            first=first.next;
        }
        System.out.println(first.data+"");
    }
    public static class ListNode{
        public int data;
        public ListNode next;

        public ListNode(int data){
            this.data=data;
        }

        public String toString(){
            return String.valueOf(this.data);
        }

    }
}

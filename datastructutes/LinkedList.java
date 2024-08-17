package com.ajay.concepts.datastructutes;

public class LinkedList {
    private ListNode head;
    private int length;
    private boolean isEmpty(){
        return length==0;
    }

    public LinkedList(){
        this.head=null;
        this.length=0;
    }


    public static class ListNode{
        public int data;
        public ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }

        public String toString(){
            return String.valueOf(this.data);
        }
    }
}

package com.ajay.concepts.linkedlist;

import com.ajay.concepts.doublylinkedlist.DoublyLinkedList1;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbers solution=new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println(7/10);
        System.out.println(7%10);

        while (result!=null){
            System.out.print(result.data+" ");
            result=result.next;
        }
    }

    private ListNode
    addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        int carry =0;
        while (l1!=null || l2!=null){
            int x = (l1!=null)?l1.data:0;
            int y = (l2!=null)?l2.data:0;
            int sum = x+y+carry;

            carry = sum/10;

            tail.next=new ListNode(sum % 10);
            tail=tail.next;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        if(carry > 0){
            tail.next=new ListNode(carry);
        }
        return dummy.next;
    }
}


class ListNode{
    int data;
    ListNode next;

    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
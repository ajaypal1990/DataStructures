package com.ajay.concepts.datastructutes;

public class MergeTwoSortedList {
    public static void main(String[] args) {

        LinkedList.ListNode list1 = new LinkedList.ListNode(1);
        list1.next = new LinkedList.ListNode(3);
        list1.next.next = new LinkedList.ListNode(5);
        list1.next.next.next = new LinkedList.ListNode(7);

        LinkedList.ListNode list2 = new LinkedList.ListNode(2);
        list2.next = new LinkedList.ListNode(4);
        list2.next.next = new LinkedList.ListNode(6);
        list2.next.next.next = new LinkedList.ListNode(8);

        LinkedList.ListNode list3 = new LinkedList.ListNode(2);
        list3.next = new LinkedList.ListNode(4);
        list3.next.next = new LinkedList.ListNode(3);


        LinkedList.ListNode list4 = new LinkedList.ListNode(5);
        list4.next = new LinkedList.ListNode(6);
        list4.next.next = new LinkedList.ListNode(4);


        //LinkedList.ListNode mergedList = mergeSortedLists(list1, list2);
        LinkedList.ListNode mergedList1 = mergeList(list1, list2);
        printList(mergedList1);

        LinkedList.ListNode twoNumbers = addTwoNumbers1(list3, list4);
        printList(twoNumbers);
    }

    private static LinkedList.ListNode addTwoNumbers1(LinkedList.ListNode list1, LinkedList.ListNode list2) {
        LinkedList.ListNode dummy=new LinkedList.ListNode(0);
        LinkedList.ListNode tail=dummy;

        int carry =0;
        while (list1!=null || list2!=null){
            int x = (list1!=null)? list1.data :0;
            int y = (list2!=null)? list1.data :0;
            int sum = x+y+carry;
            carry = sum/10;
            tail.next = new LinkedList.ListNode(sum%10);
            tail=tail.next;

            if (list1!=null)list1=list1.next;
            if(list2!=null)list2=list2.next;
        }
        if (carry>0){
            tail.next=new LinkedList.ListNode(carry);
        }
        return dummy.next;
    }


    private static void printList(LinkedList.ListNode mergedList) {
        if(mergedList==null){
            return;
        }

        while (mergedList!=null){
            System.out.print(mergedList.data+"-->");
            mergedList=mergedList.next;
        }
        System.out.println("null");
    }

    private static LinkedList.ListNode mergeSortedLists(LinkedList.ListNode list1, LinkedList.ListNode list2) {
        LinkedList.ListNode dummy=new LinkedList.ListNode(0);
        LinkedList.ListNode tail=dummy;

        while (list1!=null && list2!=null){
            if(list1.data<list2.data){
                tail.next=list1;
                list1=list1.next;
            }else {
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
        }
        if(list1==null){
            tail.next=list2;
        }else {
            tail.next=list1;
        }
        return dummy.next;
    }


    private static LinkedList.ListNode mergeList(LinkedList.ListNode list1, LinkedList.ListNode list2) {
        LinkedList.ListNode dummy = new LinkedList.ListNode(0);
        LinkedList.ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }
        return dummy.next;
    }
}

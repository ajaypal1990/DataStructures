package com.ajay.concepts.linkedlist;

public class InterviewPreprationSeriesLL1 {
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList();
        list.head=new LinkedList.ListNode<>(10);

        LinkedList.ListNode<Integer> second = new LinkedList.ListNode<>(20);
        LinkedList.ListNode<Integer> third = new LinkedList.ListNode<>(30);
        LinkedList.ListNode<Integer> fourth = new LinkedList.ListNode<>(40);



        list.head.next=second;
        second.next=third;
        third.next=fourth;

        printList(list.head);
        System.out.println();
        System.out.println("Length of the Singly Linked is : "+findLength(list.head));
        System.out.println();
        System.out.println("Adding a New Node at the Begining of the List: and Print");

        list.head = insertFirst(list.head,5);
        printList(list.head);
        System.out.println("Adding a New Node at the Last of the List: and Print");
        list.head = insertLast(list.head,50);
        printList(list.head);
        System.out.println("Adding a New Node at Position 3 of the List: and Print");
        insertAtPosition(list.head, 3,15);
        printList(list.head);
        System.out.println("Delete First Node of the List: and Print");
        list.head = deleteFirstNode(list.head);
        printList(list.head);
        System.out.println("Delete Last Node of the List: and Print");
        list.head = deleteLastNode(list.head);
        printList(list.head);
        list.head = deleteFromPosition(list.head,3);
        System.out.println("Delete Node from the position of the List: and Print");
        printList(list.head);
        System.out.println("Delete Node from the Key:30 of the List: and Print");
        list.head = deleteNodeByData(list.head,30);
        printList(list.head);

        list.head = insertFirst(list.head,5);
        insertAtPosition(list.head,3,10);
        insertLast(list.head,40);
        printList(list.head);

        //System.out.println("Remove Duplicate From the Sorted Linked List");
        list.head = removeDuplicate(list.head);
        insertLast(list.head,50);
        //printList(list.head);
        //System.out.println("Reversing the Singly Linked List");
        //list.head =reverseSinglyList(list.head);
        printList(list.head);
        findMiddleNode(list.head);

    }

    private static void findMiddleNode(LinkedList.ListNode<Integer> head) {
        LinkedList.ListNode<Integer> slowPtr = head;
        LinkedList.ListNode<Integer> fastPtr = head;
        while (fastPtr!=null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("Middle of the Node is: "+slowPtr);;
    }

    private static LinkedList.ListNode<Integer> reverseSinglyList(LinkedList.ListNode<Integer> head) {
        LinkedList.ListNode<Integer> current = head;
        LinkedList.ListNode<Integer> previous = null;
        LinkedList.ListNode<Integer> next= null;

        while (current!=null){
            next = current.next;
            current.next = previous;
            previous =current;
            current = next;
        }

        return previous;
    }

    private static LinkedList.ListNode<Integer> removeDuplicate(LinkedList.ListNode<Integer> head) {
        LinkedList.ListNode<Integer> current = head;
        while (current!=null && current.next!=null){
            if(current.data == current.next.data){
                current.next= current.next.next;
            }
            current=current.next;
        }
        return head;
    }

    private static LinkedList.ListNode<Integer> deleteNodeByData(LinkedList.ListNode<Integer> head, int data) {
        LinkedList.ListNode<Integer> current = head;
        LinkedList.ListNode<Integer> temp =null;

        while (current!=null && current.data!=data){
            temp = current;
            current=current.next;
        }
        temp.next=current.next;
        return head;
    }

    private static LinkedList.ListNode<Integer> deleteFromPosition(LinkedList.ListNode<Integer> head,int pos) {
        if (pos ==1 ){
            head = head.next;
        }else {
            LinkedList.ListNode<Integer> previous = head;
            int count = 1;
            while (count < pos-1){
                previous = previous.next;
                count++;
            }
            LinkedList.ListNode<Integer> current =previous.next;
            previous.next = current.next;
        }
        return head;
    }

    private static LinkedList.ListNode<Integer> deleteLastNode(LinkedList.ListNode<Integer> head) {
        if(head == null || head.next==null){
            return head;
        }

        LinkedList.ListNode current = head;
        LinkedList.ListNode previous = null;

        while (current.next !=null){
            previous = current;
            current=current.next;
        }
        previous.next=null;
        return head;
    }

    private static LinkedList.ListNode<Integer> deleteFirstNode(LinkedList.ListNode<Integer> head) {
        if(head == null){
            return null;
        }else {
            LinkedList.ListNode<Integer> temp = head;
            head=head.next;
            temp.next=null;
            return head;
        }
    }


    private static LinkedList.ListNode insertAtPosition(LinkedList.ListNode<Integer> head,int pos, int value) {
        LinkedList.ListNode<Integer> node=new LinkedList.ListNode<>(value);
        if(pos == 1){
            node.next=head;
            head=node;
        }else {
            int count =1;
            LinkedList.ListNode<Integer> previous = head;
            while (count< pos-1){
                previous = previous.next;
                count++;
            }
            LinkedList.ListNode<Integer> current = previous.next;
            node.next = current;
            previous.next = node;
        }
        return head;
    }

    private static LinkedList.ListNode<Integer> insertLast(LinkedList.ListNode<Integer> head, int value) {
        LinkedList.ListNode<Integer> newNode=new LinkedList.ListNode<>(value);
        LinkedList.ListNode<Integer> current = head;
        if (head == null){
            head=newNode;
            return head;
        }

        while (current.next!=null){
            current = current.next;
        }
        current.next = newNode;

        return head;
    }

    private static LinkedList.ListNode<Integer> insertFirst(LinkedList.ListNode<Integer> head, int value) {
        LinkedList.ListNode<Integer> listNode=new LinkedList.ListNode<>(5);
        listNode.next=head;
        head=listNode;
        return head;
    }

    private static int findLength(LinkedList.ListNode<Integer> head) {
        int count =0;
        LinkedList.ListNode current = head;
        while (current!=null){
            count++;
            current=current.next;
        }
        return count;
    }

    private static void printList(LinkedList.ListNode head) {
        LinkedList.ListNode<Integer> current = head;

        while (current!=null){
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }
}

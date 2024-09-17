package com.ajay.concepts;

public class StackImpl {
    public static void main(String[] args) {

    }
}

class Stack1{
    private int[] stack;
    int top;
    int capacity;

    public Stack1(int capacity){
       stack= new int[capacity];
       top =-1;
       this.capacity=capacity;
    }

    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == capacity-1;
    }

    public void push(int data){
        if(isFull()){

        }
        stack[++top] = data;
    }

    public int pop(){
        if(isEmpty()){

        }
        return stack[top--];
    }
}
class Stack{
    private int[] stack;
    private int top;
    private int capacity;

    public Stack(int capacity){
        stack=new int[capacity];
        top=-1;
        this.capacity=capacity;
    }

    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == capacity-1;
    }

    public void push(int val){
        if(isFull()){

        }
        stack[++top]=val;
    }
    public int pop(){
        if(isEmpty()){

        }
        return stack[top--];
    }
    public int peek(){
        if(isEmpty()){

        }
        return stack[top];
    }
}

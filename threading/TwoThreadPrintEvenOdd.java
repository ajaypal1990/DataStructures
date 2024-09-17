package com.ajay.concepts.threading;

public class TwoThreadPrintEvenOdd {
    public static void main(String[] args) {
        PrintEvenOdd1 printEvenOdd1 =new PrintEvenOdd1();
        Thread thread1=new Thread(printEvenOdd1::printOddValue);
        Thread thread2=new Thread(printEvenOdd1::printEvenValue);

        thread1.start();
        thread2.start();

    }
}

class PrintEvenOdd1{

    private int count = 0;
    private final int limit = 20;

    public void printOddValue(){
        synchronized (this){
            while (count  < limit){
                while (count % 2 == 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("odd: "+count);
                count++;
                notify();
            }
        }
    }

    public void printEvenValue(){
        synchronized (this){
            while (count  < limit){
                while (count % 2 != 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("even: "+count);
                count++;
                notify();
            }
        }
    }
}

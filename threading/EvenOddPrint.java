package com.ajay.concepts.threading;

public class EvenOddPrint {
    public static void main(String[] args) {
        PrintEvenOdd printEvenOdd = new PrintEvenOdd();

        Thread thread1 = new Thread(printEvenOdd::printEven);
        Thread thread2 = new Thread(printEvenOdd::printOdd);

        thread1.start();
        thread2.start();
    }
}

class PrintEvenOdd {
    private int count = 1;
    private final int limit = 20;

    public void printOdd() {
        synchronized (this) {
            while (count < limit) {
                while (count % 2 == 0) { // Wait if it's not odd
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("odd: " + count);
                count++;
                notify(); // Notify the even thread
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (count < limit) {
                while (count % 2 != 0) { // Wait if it's not even
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("even: " + count);
                count++;
                notify(); // Notify the odd thread
            }
        }
    }
}

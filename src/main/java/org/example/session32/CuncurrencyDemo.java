package org.example.session32;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;
import static java.lang.Thread.sleep;

public class CuncurrencyDemo {

    // Example 1 RACE CONDITION
    static class UnsafeCounter{
        private int count = 0;
        public void increment(){count ++;}
        public int getCount() {return count;}
    }

    static class SyncronizedCounter{
        private int count = 0;
        public synchronized void increment() {count ++;}
        public synchronized int getCount() {return count;}
    }

    static class AtomicCounter{
        private final AtomicInteger count = new AtomicInteger(0);
        public void increment(){count.incrementAndGet();}
        public int getCount() {return  count.get();}
    }

    //Exemplu 2 DeadLock
    static class DeadLockDemo{
        private final Object lockA = new Object();
        private final Object lockB = new Object();

        public void task1() throws InterruptedException {
            synchronized (lockA) {
                sleep(100);
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + " required A and B");
                }
            }
        }

        public void task2() throws InterruptedException {
            synchronized (lockB){
                sleep(100);
                synchronized (lockA){
                    System.out.println(Thread.currentThread().getName() + " required A and B");
                }
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        UnsafeCounter unsafe = new UnsafeCounter();
        Thread t1 = new Thread( () -> { for ( int i=0; i<10000; i++) unsafe.increment();}, "Thread unsafe 1");
        Thread t2 = new Thread( () -> { for ( int i=0; i<10000; i++) unsafe.increment();}, "Thread unsafe 2");
        t1.start();t2.start();t1.join();t2.join();
        System.out.println("Unsafe Counter results over 20000 execution " + unsafe.getCount());

        SyncronizedCounter syncronizedCounter = new SyncronizedCounter();
        Thread t3 = new Thread( () -> { for ( int i=0; i<10000; i++) syncronizedCounter.increment();}, "Thread Sync 3");
        Thread t4 = new Thread( () -> { for ( int i=0; i<10000; i++) syncronizedCounter.increment();}, "Thread Sync 4");
        t3.start();t4.start();t3.join();t4.join();
        System.out.println("Symc Counter results over 20000 execution " + syncronizedCounter.getCount());

        AtomicCounter atomicCounter = new AtomicCounter();
        Thread t5 = new Thread( () -> { for ( int i=0; i<10000; i++) atomicCounter.increment();}, "Thread Atomic 5");
        Thread t6 = new Thread( () -> { for ( int i=0; i<10000; i++) atomicCounter.increment();}, "Thread Atomic 6");
        t5.start();t6.start();t5.join();t6.join();
        System.out.println("Atomic Counter results over 20000 execution " + atomicCounter.getCount());

        DeadLockDemo demo = new DeadLockDemo();
        Thread d1 = new Thread(() -> {
            try {
                demo.task1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Dead1");
        Thread d2 = new Thread(() -> {
            try {
                demo.task2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Dead2");
        d1.start();
        d2.start();
    }


}

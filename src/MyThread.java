/*
Thread Class - Practical
- Create class which extend Thread class and  override run method.

- Create main class and create object of class. Create multiple thread and run the thread.

- Print message should be display on console for each thread.
 */

public class MyThread extends Thread {

    String name;
    MyThread(String name){
        this.name = name; // initialize name variable.
    }

    // CET(Current Executing Thread)
    public void printCETName(){

        Thread.currentThread().setName(name); // set the name of current executing thread.
        String ctName = Thread.currentThread().getName();
        System.out.println("Current Executing Thread : "+ctName); // prints the name of current executing thread.

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("I got interrupted : "+e.getMessage());
        }

    }

    // run() method code is only executed by thread.
    @Override
    public void run() {
        printCETName(); // prints all current executing thread
    }
}

class Main {

    public static void main(String[] args) throws InterruptedException {

        // Thread creation
        MyThread t1 = new MyThread("Thread-t1");
        MyThread t2 = new MyThread("Thread-t2");
        MyThread t3 = new MyThread("Thread-t3");
        MyThread t4 = new MyThread("Thread-t4");
        MyThread t5 = new MyThread("Thread-t5");

        // Thread calls start() method to start its own execution
        t1.start();
        t1.join(); // It won't allow main thread to execute, till the time t1 completely executes itself.
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}
package basics.multithreading;
/*
notes refer
https://codewitharyan.com/tech-blogs/threads-thread-class-and-runnable-interface
*/


// Implementation using Runnable interface
public class myThread extends Thread {
    public myThread(myRunnable runnable){
        super(runnable);
    }

    public static void main(String[] args) {
        myRunnable runnable = new myRunnable();
        myThread thread1 = new myThread(runnable);
        myThread thread2 = new myThread(runnable);
        thread1.start();
        thread2.start();
    }
}

class myRunnable implements Runnable{
    // better way to implement threads i-e using Runnable Interface
    @Override
    public void run() {
        for (int i = 0; i <7; i++) {
            System.out.println("Thread "+Thread.currentThread().getId()+":"+i);
        }
        try{
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.println("Thread Interrupted");
        }
    }
}

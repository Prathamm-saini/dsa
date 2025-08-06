package basics.multithreading;

public class introduction {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.println("Thread "+ Thread.currentThread().getId()+" "+i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(" Thread Interrupted");
            }
        }
    }
}
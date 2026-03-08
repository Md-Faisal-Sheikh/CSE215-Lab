package threads;

/**
 *
 * @author Asus
 */
public class Threads extends Thread {
    @Override
    public void run(){
        System.out.println("The thread is running");
    }
    public static void main(String[] args) {
        Threads t = new Threads();
        t.start();
    }
}
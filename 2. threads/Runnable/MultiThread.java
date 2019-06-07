class ThreadProgram implements Runnable {
    
    int start;
    
    public ThreadProgram(int start) {
        this.start = start;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        for (int i=start; i<10+start; i++) {
            System.out.println(i);
        }
    }
}

public class MultiThread {
    public static void main(String[] args) {
        
        for (int i=0; i<10; i++) {
            new ThreadProgram(i);
        }
    }
}
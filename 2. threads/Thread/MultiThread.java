class ThreadProgram extends Thread {
    
    int start;
    
    public ThreadProgram(int i) {
        this.start = i;
    }

    public void run() {
        for (int i=start; i<10+start; i++) {
            System.out.println(i);
        }
    }
}

public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        
        for (int i=0; i<10; i++) {
            new ThreadProgram(i).start();
            //Thread.sleep(100);
        }
    }
}
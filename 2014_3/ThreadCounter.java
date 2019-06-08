class TreadCounter extends Thread {

    private int x;

    public TreadCounter(int x) {
        this.x = x;
    }

    public void run() {
        
        int i=x;
        
        while (true) {
            System.out.println("Thread " + x + ": " + i++);
            try {
                sleep(100);
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        for (int i=1; i<=10; i++)
            new TreadCounter(i).start();
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {}
    }
}

class RunnableCounter implements Runnable {
    
    private int x;
    
    RunnableCounter(int x) {
        this.x = x;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        int i=x;
        
        while (true) {
            System.out.println("Thread " + x + ": " + i++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        for (int i=1; i<=10; i++)
            new RunnableCounter(i);
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {}
    }
}
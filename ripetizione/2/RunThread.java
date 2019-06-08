class RunThread extends Thread{
    int i;

    RunThread(int i) {
        this.i=i;
        this.start();
    }

    public void run() {
        int n=i;
        
        while(true) {
            System.out.println("Thread " + i + ": " + ++n);
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            new RunThread(i);
        }
    }
}

class RunRunnable implements Runnable {
    int i;
    
    RunRunnable(int i) {
        this.i=i;
        new Thread(this).start();
    }

    public void run() {
        int n=i;
        
        while(true) {
            System.out.println("Thread " + i + ": " + ++n);
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            new RunThread(i);
        }
    }
}
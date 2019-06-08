public class ExceptionExample {
    public static void main(String[] args) throws Error {
        
        if (Math.random() > .5) { 
            throw new Error();
        } else {
            throw new RuntimeException();
        }
    }
}
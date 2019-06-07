public class ThrowException {
    public static void main(String[] args) {
        
        int a = 5;
        int b = 5;
        int c = 0;
        
        try {
            c = a+b;
            if (c != 7)
                throw new RuntimeException("c should be 7!");
        } catch (RuntimeException e) {
            c = 7;
        }
        finally {
            a = 0;
            b = 0;
        }

        System.out.println(Integer.toString(a) + Integer.toString(b) + Integer.toString(c));
    }
}
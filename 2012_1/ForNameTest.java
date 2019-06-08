class Penguin {
    static {
        System.out.println("Penguin");
    }
}

public class ForNameTest {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("Penguin");
    }
}
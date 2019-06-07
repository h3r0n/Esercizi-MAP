import java.util.List;
import java.util.ArrayList;

class TestClass {
    public <T> void genericMethos(T x) {
        System.out.println(x.getClass().getName());
    }
}


class Fruit {
    String name;
}

class Apple extends Fruit {}
class Orange extends Fruit {}



public class Generics {
    public static void main(String[] args) {
        
        // ArrayList<Integer> and ArrayList<String>() are the same at runtime -> Erasure
        System.out.println( (new ArrayList<Integer>()).getClass() == (new ArrayList<String>()).getClass() );

        // Wildcard
        Class<? extends Fruit> c = Apple.class;
        
        Class d = ArrayList.class;

        // Cannot use .class with generic classes -> Erasure
        //Class e = ArrayList<String>.class; -> Error!

        //List<Fruit> list = new ArrayList<Apple>(); -> Error!: ArrayList<Apple> is not a List<Fruit>
        List<? extends Fruit> list = new ArrayList<Apple>();  // solution: wildcard  

        //list.add(new Apple()); -> Error!
        Fruit f = list.get(0);

    }
}
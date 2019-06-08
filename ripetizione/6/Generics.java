import java.util.ArrayList;

class Food {}
class Fruit extends Food {}
class Apple extends Fruit {}


public class Generics {
    public static void main(String[] args) {
        ArrayList<String> l1 = new ArrayList<String>();
        ArrayList<String> l2 = new ArrayList<String>();

        System.out.println(l1.getClass()==l2.getClass());

        ArrayList<Apple> l3 = new ArrayList<Apple>();
        ArrayList<? extends Fruit> l4 = l3;
        l3.add(new Apple());
        //l4.add(new Apple());  //error!
        l4.get(0);

        ArrayList<? super Fruit> l5 = new ArrayList<Food>();
    }
}
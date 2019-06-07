import java.util.ArrayList;
import java.util.List;

class Int implements Cloneable {

    private int i;

    Int(int i) {
        this.i = i;
    }

    public void increment() {
        i++;
    }

    public Object clone() {
        
        Object o = null;
        
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    public int getValue() {
        return i;
    }
}

public class Cloning {
    public static void main(String[] args) {
        
        boolean equal;

        ArrayList list1 = new ArrayList();
        
        for (int i=0; i<10; i++) {
            list1.add(new Int(i));
        }
        
        // shallow copy
        ArrayList list2 = (ArrayList) list1.clone();

        ((Int)list2.get(0)).increment();

        equal = true;
        for (int i=0; i<10; i++) {
            if ( ((Int)list1.get(i)).getValue() != ((Int)list2.get(i)).getValue() )
                equal = false;
        }
        System.out.println(equal);  // true because Int objects are the same instances

        // deep copy
        for (int i=0; i<10; i++) {
            list2.set(i, ((Int)list1.get(i)).clone());
        }

        ((Int)list2.get(0)).increment();

        equal = true;
        for (int i=0; i<10; i++) {
            if ( ((Int)list1.get(i)).getValue() != ((Int)list2.get(i)).getValue() )
                equal = false;
        }
        System.out.println(equal);  // false because Int objects are different instances
    }

}
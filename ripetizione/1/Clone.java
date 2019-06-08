import java.util.ArrayList;

public class Clone implements Cloneable {
    
    public int i;

    Clone(int i) {
        this.i=i;
    }

    public Object clone() {
        
        Object o=null;
        
        try {
            o= super.clone();
        } catch (Exception e) {}

        return o;
    }

    public boolean equals(Object o) {
        return i==((Clone)o).i;
    }

    public static void main(String[] args) {
        ArrayList<Clone> list1 = new ArrayList<>();
        list1.add(new Clone(1));
        list1.add(new Clone(2));
        list1.add(new Clone(3));

        // shallow copy
        ArrayList<Clone> list2 = (ArrayList<Clone>) list1.clone();
        System.out.println( list1.get(1) == list2.get(1) ); // stesso riferimento

        // deep copy
        for (int i=0; i<list1.size(); i++) {
            list2.set(i, (Clone) list1.get(i).clone());
        }
        System.out.println( list1.get(1) == list2.get(1) ); // riferimento diverso
        System.out.println( list1.get(1).equals(list2.get(1)) ); // stesso valore
    }
}
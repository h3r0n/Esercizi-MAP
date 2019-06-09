import java.io.*;
import java.util.*;

class Cella implements Serializable {
    int x;
    int y;

    Cella(int x, int y) {
        this.x=x;
        this.y=y;
    }
    
    public boolean equals(Object o) {
        return x==((Cella)o).x && y==((Cella)o).y;
    }

    public int hashCode() {
        return x * 31 + y * 17;
    }
}

class Nave implements Serializable {}

public class MappaNavale extends HashMap<Cella,HashSet<Nave>> implements Serializable {
    public static MappaNavale creaMappa() {
        return new MappaNavale();
    }

    public void assegnaNaveACella(Cella c,Nave n) {
        if (this.containsKey(c)) {
            get(c).add(n);
        } else {
            HashSet<Nave> s = new HashSet<>();
            s.add(n);
            this.put(c,s);
        }
    }

    public int contaNavi(Cella c) {

        if (this.containsKey(c)) {
            return this.get(c).size();
        } 
        
        return 0;
    }

    public void save(String file) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        try {
            out.writeObject(this);
        } finally {
            out.close();
        }
    }

    public static MappaNavale restore(String file) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        try {
            return (MappaNavale) in.readObject();
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) throws Exception {
        MappaNavale m = new MappaNavale();
        m.assegnaNaveACella(new Cella(5,5), new Nave());
        m.assegnaNaveACella(new Cella(5,5), new Nave());

        System.out.println(m.contaNavi(new Cella(5,5)));
        System.out.println(m.contaNavi(new Cella(1,1)));

        m.save("mappa.dat");
        m = null;
        m = MappaNavale.restore("mappa.dat");

        System.out.println(m.contaNavi(new Cella(5,5)));
        System.out.println(m.contaNavi(new Cella(1,1)));
    }
}
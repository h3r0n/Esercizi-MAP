import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Nave implements Serializable {
}

class Cella extends HashSet<Nave> implements Serializable {
}

public class MappaNavale implements Serializable {
    public Cella[][] matrice;

    public MappaNavale(int x, int y) {
        matrice = new Cella[x][y];

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++) {
                matrice[i][j] = new Cella();
            }
    }

    public static MappaNavale creaMappa(int x, int y) {
        return new MappaNavale(x, y);
    }

    public static void assegnaNaveACella(Cella c, Nave n) {
        if (c == null) {
            c = new Cella();
        }
        c.add(n);
    }

    public Cella getCella(int x, int y) {
        return matrice[x][y];
    }

    public static int contaNavi(Cella c) {
        return c.size();
    }

    public void save() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.dat"));
        out.writeObject(this);
        out.close();
    }

    public static MappaNavale load() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.dat"));
        MappaNavale m = (MappaNavale) in.readObject();
        in.close();
        return m;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        MappaNavale m = new MappaNavale(10,10);

        Cella c = m.getCella(5, 5);
        Cella d = m.getCella(0, 0);
        
        MappaNavale.assegnaNaveACella(c, new Nave());
        MappaNavale.assegnaNaveACella(c, new Nave());

        m.save();
        m = null;
        m = MappaNavale.load();

        System.out.println(MappaNavale.contaNavi(c));
        System.out.println(MappaNavale.contaNavi(d));
    }
}

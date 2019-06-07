import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

class Voto implements Serializable {
    public int punteggio;

    public Voto(int n) {
        punteggio = n;
    }

    public boolean equals(Object o) {
        return punteggio == ((Voto)o).punteggio;
    }
}

class Esame implements Serializable {
    public String nomeEsame;

    public Esame(String s) {
        nomeEsame = s;
    }

    public boolean equals(Object o) {
        return nomeEsame.equals(((Esame)o).nomeEsame);
    }

    public int hashCode() {
        return nomeEsame.hashCode();
    }
}

public class Libretto implements Serializable {
    HashMap<Esame, Voto> registro = new HashMap<>();

    public static Libretto creaLibretto() {
        return new Libretto();
    }

    public void verbalizza(Esame e, Voto v) {
        registro.put(e, v);
    }

    public Voto leggivoto(Esame e) {
        return registro.get(e);
    }

    public boolean equals(Object o) {
        return registro.equals(((Libretto) o).registro);
    }

    public boolean uguale(Libretto l) {
        return this.equals(l);
    }

    public void save() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.dat"));
        out.writeObject(this);
        out.close();
    }

    public static Libretto restore() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.dat"));
        Libretto l = (Libretto) in.readObject();
        in.close();
        return l;
    }

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        
        Libretto l1 = new Libretto();

        l1.verbalizza(new Esame("MAP"), new Voto(16));
        l1.verbalizza(new Esame("ING"), new Voto(17));

        l1.save();

        Libretto l2 = Libretto.restore();

        System.out.println(l1.uguale(l2));

        l2.leggivoto(new Esame("ING")).punteggio = 16;
        System.out.println(l1.uguale(l2));
    }
}
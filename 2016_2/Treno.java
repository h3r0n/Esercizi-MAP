import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

class Posto implements Serializable {

    public int codicePosto;

    public Posto(int n) {
        codicePosto = n;
    }

    public int hashCode() {
        return codicePosto;
    }

    public boolean equals(Object o) {
        return codicePosto == ((Posto) o).codicePosto;
    }
}

class Prenotazione implements Serializable {

    public String CF;

    public Prenotazione(String CF) {
        this.CF = CF;
    }

    public boolean equals(Object o) {
        return CF.equals(((Prenotazione) o).CF);
    }
}

public class Treno implements Serializable {

    private HashMap<Posto, Prenotazione> posti = new HashMap<>();

    Treno creaTreno() {
        return new Treno();
    }

    public void prenota(Posto posto, Prenotazione prenotazione) {
        posti.put(posto, prenotazione);
    }

    public void leggiPrenotazione(Posto posto) {
        System.out.println(posti.get(posto).CF);
    }

    public boolean uguale(Treno treno) {
        return posti.equals(treno.posti);
    }

    public void saveToFile(String file) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(this);
        out.close();
    }

    public static Treno restoreFromFile(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Treno t = (Treno) in.readObject();
        in.close();
        return t;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Treno treno = new Treno();

        treno.prenota(new Posto(10), new Prenotazione("ASD"));
        treno.leggiPrenotazione(new Posto(10));

        treno.saveToFile("file.dat");
        treno = null;
        treno = Treno.restoreFromFile("file.dat");

        treno.leggiPrenotazione(new Posto(10));
    }
}
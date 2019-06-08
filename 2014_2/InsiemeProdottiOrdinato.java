import java.util.HashSet;
import java.util.TreeSet;

class Prodotto implements Comparable {
    public String codiceProdotto;
    String nome;
    float prezzo;

    Prodotto(String c, String n, float p) {
        codiceProdotto = c;
        nome = n;
        prezzo = p;
    }

    public int compareTo(Object o) {
        return codiceProdotto.compareTo(((Prodotto)o).codiceProdotto);
    }
    
    public int hashCode() {
        return codiceProdotto.hashCode();
    }

    public boolean equals(Object o) {
        return codiceProdotto.equals(((Prodotto)o).codiceProdotto);
    }
    
}

public class InsiemeProdottiOrdinato extends HashSet<Prodotto> {

    public static void main(String[] args) {
        InsiemeProdottiOrdinato i = new InsiemeProdottiOrdinato();

        i.add(new Prodotto("ASD", "asd", 1));
        i.add(new Prodotto("LOL", "lol", 2));
        i.add(new Prodotto("ASD", "asd", 3));

        for (Prodotto p : i) {
            System.out.println(p.codiceProdotto);
        }   
    }
}
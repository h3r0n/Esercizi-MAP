import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable {
    String nome;
    String cognome;
    String CF;
    float reddito;

    public Person(String nome, String cognome, String CF, float reddito) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.reddito = reddito;
    }

    public int compareTo(Object o) {

        if ( ((Person)o).CF.equals(CF) ) {
            return 0;
        }

        int compare = (int) (((Person)o).reddito - reddito);

        if (compare==0)
            compare = CF.compareTo(((Person)o).CF);

        return compare;
    }

    public String getNome() {
        return nome + " " + cognome;
    }
}

public class Sort {
    public static void main(String[] args) {
        TreeSet<Person> set = new TreeSet();

        set.add(new Person("Tizio", "Rossi", "TZRSS", 100));
        set.add(new Person("Caio", "Bianchi", "CABNC", 1));
        set.add(new Person("Caio", "Bianchi", "CABNC", 1));
        set.add(new Person("Sempronio", "Verdi", "SMVRD", 100));

        for (Person p : set) {
            System.out.println(p.getNome());
        }
    }
}
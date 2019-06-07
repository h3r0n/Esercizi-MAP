import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person {
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

    public String getNome() {
        return nome + " " + cognome;
    }
}

class PersonComparator implements Comparator {
   
    public int compare(Object o1, Object o2) {

        if ( ((Person)o1).CF.equals(((Person)o2).CF) ) {
            return 0;
        }

        int comparison = (int) (((Person)o2).reddito - ((Person)o1).reddito);

        if (comparison==0)
            comparison = ((Person)o1).CF.compareTo(((Person)o2).CF);

        return comparison;
    }
}

public class Sort {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet(new PersonComparator());

        set.add(new Person("Tizio", "Rossi", "TZRSS", 10));
        set.add(new Person("Caio", "Bianchi", "CABNC", 1));
        set.add(new Person("Gaio", "Blanc", "CABNC", 2));
        set.add(new Person("Sempronio", "Verdi", "SMVRD", 100));

        for (Person p : set) {
            System.out.println(p.getNome());
        }
    }
}
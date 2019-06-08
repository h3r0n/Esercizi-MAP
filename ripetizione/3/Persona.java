import java.util.*;

class Persona implements Comparable {
    String CF;
    float reddito;

    Persona(String CF, float reddito) {
        this.CF = CF;
        this.reddito = reddito;
    }

    public void print() {
        System.out.println(CF + " " + reddito);
    }

    public int compareTo(Object o) {
        if ( CF.equals(((Persona)o).CF)) {
            return 0;
        }

        if ( (int) (reddito-((Persona)o).reddito) == 0 ) {
            return CF.compareTo(((Persona)o).CF);
        }

        return (int) (reddito - ((Persona) o).reddito);
    }

    public static void main(String[] args) {
        Set<Persona> persone1 = new TreeSet<>();
        persone1.add(new Persona("1", 1));
        persone1.add(new Persona("1", 1));
        persone1.add(new Persona("2", 3));
        persone1.add(new Persona("3", 2));
        
        for (Persona p : persone1) {
            p.print();
        }
    }
}

class PersonaComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        if ( ((Persona)o1).CF.equals(((Persona)o2).CF)) {
            return 0;
        }

        if ( (int) (((Persona)o1).reddito-((Persona)o2).reddito) == 0 ) {
            return ((Persona)o1).CF.compareTo(((Persona)o2).CF);
        }

        return (int) (((Persona)o1).reddito-((Persona)o2).reddito);
    }

    public static void main(String[] args) {
        Set<Persona> persone2 = new TreeSet<>(new PersonaComparator());
        persone2.add(new Persona("1", 1));
        persone2.add(new Persona("1", 1));
        persone2.add(new Persona("2", 3));
        persone2.add(new Persona("3", 2));
        
        for (Persona p : persone2) {
            p.print();
        }
    }
}
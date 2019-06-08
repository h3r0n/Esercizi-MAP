import java.util.Comparator;

class Studente implements Comparable {
    
    String nome;
    int eta;
    
    Studente (String nome, int eta){
        this.nome=nome;
        this.eta=eta;
    }

    public int compareTo(Object o) {
        return nome.compareTo(((Studente)o).nome);
    }

    public static void main(String[] args) {
        Studente a[] = new Studente[3];
        a[0] = new Studente("Tizio", 1);
        a[1] = new Studente("Caio", 2);
        a[2] = new Studente("Sempronio", 3);

        Studente b[] = new Studente[3];
        b[0] = new Studente("Tizio", 1);
        b[1] = new Studente("Caio", 2);
        b[2] = new Studente("Sempronio", 3);

        System.out.println(a[Minimo.minimo(a)].nome );
        System.out.println(a[Minimo.minimo(a, new StudenteComparator())].nome);
    }
}

class StudenteComparator implements Comparator<Studente> {
    public int compare(Studente s1, Studente s2) {
        return s1.nome.compareTo(s2.nome);
    }
}

class Minimo {
    
    public static int minimo(Comparable a[]) {
        
        int minimo = 0;
        
        for (int i=1; i<a.length; i++) {
            if ( a[minimo].compareTo(a[i]) > 0 ) {
                minimo = i;
            }
        }

        return minimo;
    }

    public static int minimo(Object a[], Comparator c) {
        
        int minimo = 0;

        for (int i=1; i<a.length; i++) {
            if ( c.compare(a[minimo],a[i]) > 0 ) {
                minimo = i;
            }
        }
       
        return minimo;
    }
}
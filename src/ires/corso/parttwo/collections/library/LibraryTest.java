package ires.corso.parttwo.collections.library;
import javafx.collections.transformation.SortedList;

import java.util.*;

public class LibraryTest {
    private static final Set<Libro> archivio_libri = new HashSet<>();
    private static final Set<Categoria> archivio_categorie = new HashSet<>();
    private static final Set<Utente> archivio_utenti = new HashSet<>();

    private final static Map<Libro, Set<Categoria>> libriConCategorie = new HashMap<>();
    private final static Map<Utente, List<Prestito>> utentiConPrestiti = new HashMap<>();

    public static void main(String[] args) {
        Libro b1 = new Libro( "Harry Potter", "J. K. Rowling", "1997", "Bloomsbury", 223, 1, 20);
        Libro b2 = new Libro("Il Signore Degli Anelli", " J. R. R. Tolkien", "1955", "Bloomsbury 2", 1432, 3, 30);
        Libro b3 = new Libro("Alice Nel Paese Delle Meraviglie", "Charles Lutwidge Dodgson", "1937", "Mondadori", 100, 3, 40);
        Libro b4 = new Libro("20.000 Leghe Sotto I Mari", "Jules Verne", "1957", "Einaudi", 99, 2, 50);
        Libro b5 = new Libro("Assassinio Sull'Orient Express", "Aghata Christie", "1935", "Newton", 394, 6, 60);
        Libro b6 = new Libro("Sherlock Holmes", "Arthur Conan Doyle", "1956", "Penguin", 253, 5, 70);
        Libro b7 = new Libro("Divina Commedia" ,"Dante Alighieri", "1934", "Oscar", 555, 4, 80);
        Libro b8 = new Libro("Il Grande Gatsby", "Fitzgerald", "1922", "Books", 654, 3, 90);

        archivio_libri.addAll( Arrays.asList( b1, b2, b3, b4, b5, b6, b7, b8 ) );
        for( Libro libro : archivio_libri )
            addBook( libro );

        Categoria c1 = new Categoria( "Fantasy", "Racconti di fantasia" );
        Categoria c2 = new Categoria( "Giallo", "Racconti gialli" );
        Categoria c3 = new Categoria( "Classici", "Racconti classici" );
        Categoria c4 = new Categoria( "Avventura", "Racconti d'avventura" );
        Categoria c5 = new Categoria( "Poesia", "Poesie" );

        archivio_categorie.addAll( Arrays.asList( c1, c2, c3, c4, c5 ) );

        addCategories( b1, Arrays.asList( c1, c4 ) );
        addCategories( b2, Arrays.asList( c1, c3, c4 ) );
        addCategories( b3, Arrays.asList( c1, c3 ) );
        addCategories( b4, Arrays.asList( c1, c3 ) );
        addCategories( b5, Arrays.asList( c2, c3 ) );
        addCategories( b6, Arrays.asList( c2, c3 ) );
        addCategories( b7, Arrays.asList( c3, c5 ) );
        addCategories( b8, Arrays.asList( c3 ) );

        Utente u1 = new Utente("Marco", "Rossi", "1234" );
        Utente u2 = new Utente("Luca", "Bianco", "22223");
        Utente u3 = new Utente("Mario", "Verdi", "33334");

        archivio_utenti.addAll( Arrays.asList( u1, u2, u3 ) );
        for( Utente utente : archivio_utenti )
            addUtente( utente );

        addPrestito( u1, Arrays.asList( b1, b8, b4 ) );
        addPrestito( u2, Arrays.asList( b2, b3, b4 ) );
        calculatePrestiti("Giorno 1");

        addPrestito( u3, Arrays.asList( b6, b2, b7 ) );
        addPrestito( u2, Arrays.asList( b8, b1, b2 ) );
        addPrestito( u1, Arrays.asList( b8, b3, b5 ) );
        calculatePrestiti( "Giorno 2" );
    }

    public static void addBook( Libro libro ){
        if( libriConCategorie.containsKey( libro ) ){
            System.out.println("Errore: il libro è già presente.");
            return;
        }

        libriConCategorie.put( libro, new HashSet<Categoria>() );
    }

    public static void addCategories( Libro libro, List<Categoria> categorie ){
        if( !libriConCategorie.containsKey( libro ) ){
            System.out.println("Errore: il libro non è presente.");
            return;
        }

        Set<Categoria> categorieSet = libriConCategorie.get( libro );
        categorieSet.addAll( categorie );
    }

    public static void addUtente( Utente utente ){
        if( utentiConPrestiti.containsKey( utente ) ){
            System.out.println("Errore, l'utente è già presente.");
            return;
        }

        utentiConPrestiti.put( utente, new ArrayList<Prestito>() );
    }

    public static void addPrestito( Utente utente, List<Libro> libri ){
        if( !utentiConPrestiti.containsKey( utente ) ){
            System.out.println("Errore: l'utente non esiste.");
            return;
        }

        List<Prestito> prestiti = utentiConPrestiti.get( utente );
        Prestito prestito = new Prestito( utente, libri );
        prestiti.add( prestito );
    }

    public static void calculatePrestiti( String msg ){
       Map<Categoria, List> categorieConPrestiti = new HashMap<>();

       for( Categoria categoria : archivio_categorie )
           categorieConPrestiti.put( categoria, new ArrayList<Prestito>() );

        for( List<Prestito> prestiti : utentiConPrestiti.values() ){
            for( Prestito prestito : prestiti ){
                Iterator<Libro> iLibri = prestito.getLibri();
                while( iLibri.hasNext() ){
                    Libro libro = iLibri.next();
                    Set<Categoria> categorie = libriConCategorie.get( libro );
                    for( Categoria categoria : categorie )
                        categorieConPrestiti.get( categoria ).add( prestito );
                }
            }
        }

        List<Map.Entry<Categoria, List>> sortedList = new ArrayList<Map.Entry<Categoria, List>>( categorieConPrestiti.entrySet() );
        Comparator<Map.Entry<Categoria, List>> comparator = new Comparator<Map.Entry<Categoria, List>>() {
            @Override
            public int compare(Map.Entry<Categoria, List> o1, Map.Entry<Categoria, List> o2) {
                Integer size1 = o1.getValue().size();
                Integer size2 = o2.getValue().size();
                Integer result = -size1.compareTo( size2 );
                if( result == 0 ) {
                    String titolo1 = o1.getKey().getTitolo();
                    String titolo2 = o2.getKey().getTitolo();
                    result = titolo1.compareTo( titolo2 );
                }
                return result;
            }
        };
        Collections.sort( sortedList, comparator );

        System.out.println( msg );
        for( Map.Entry<Categoria, List> entry : sortedList ){
            Categoria categoria = entry.getKey();
            int nPrestiti = categorieConPrestiti.get( categoria ).size();
            System.out.printf( "La categoria %s ha avuto %d prestiti.\n", categoria.getTitolo(), nPrestiti );
        }
        System.out.println();
    }
}

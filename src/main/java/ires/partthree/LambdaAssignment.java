package ires.partthree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LambdaAssignment {
    public static void main(String[] args) {
        // 1. Data una lista di nomi:
        //    - Agnese Stefano, Niki, Veronica, GabrieleM, Davide, GabrieleG, Alessandor, Albnerto, Fabiola, Alessio, Daniele
        //    - ...partire con un ArrayList che li contiene;
        //    - trasformarlo in stream
        //    - filtrare (escludendoli) i nomi che hanno lunghezza < 5 lettere
        //    - trasformare con UPPERCASE i rimanenti
        //    - stamparli su schermo
        //    ...concatenando il più possibile le varie operazioni

        List<String> names = Arrays.asList(
                "Agnese", "Stefano", "Niki", "Veronica", "GabrieleM", "Davide", "GabrieleG", "Alessandor",
                "Albnerto", "Fabiola", "Alessio", "Daniele"
        );

        Stream<String> result = names.stream().filter( s -> s.length() >= 5 ).map( s -> s.toUpperCase() );
        System.out.println( result.collect(Collectors.toList()) );

        // 2. Fare un programma Java che:
        //    - chiede all'utente una lista di numeri (separati da virgola) <== RIUSATE IL CODICE DEL SORTING GAME
        //    - li trasforma in stream
        //    - filtra i duplicati (HINT: guardate bene i metodi dell'interfaccia Stream...)
        //    - eleva al quadrato i numeri filtrati
        //    - calcola la media (HINT: operazione terminale chiamata "average": https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/stream/IntStream.html#average())

        Scanner in = new Scanner( System.in );
        System.out.println("Inserisci una lista di numeri separati da virgola: ");
        boolean valid;
        do {
            valid = true;
            Stream<String> numbersString =  Arrays.asList( in.nextLine().split(",") ).stream();
            LongStream longStream = numbersString.map(String::trim).mapToLong(n -> Long.parseLong(n));
            try {
                OptionalDouble averageResult = longStream.distinct().map( n -> n * n ).average();
                if( !averageResult.isPresent() ){
                    System.out.println("Errore, non è possibile calcolare la media di questa lista, riprova.");
                    valid = false;
                }
                System.out.println("La media dei quadrati dei numeri univoci inseriti è: " + averageResult.getAsDouble());
            }catch( NumberFormatException e ){
                System.out.println("Errore, non hai inserito una lista di numeri, riprova.");
                valid = false;
            }
        }while( !valid );
    }
}

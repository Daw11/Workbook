package ires.partone;

public class StringTest {

    public static void main(String[] args){
        if( args.length != 3 ){
            System.out.println("Devi inserire 3 stringhe.");
            return;
        }

        for( int i = 0; i < 3; i++ ){
            String str = args[i];
            int str_length = str.length();
            char str_start = str.charAt( 0 );
            char str_end = str.charAt( str_length -1 );
            String msg = String.format("La stringa %s ha lunghezza %d comincia per %c e finisce per %c", str, str_length, str_start, str_end);
            System.out.println( msg );
        }
    }
}

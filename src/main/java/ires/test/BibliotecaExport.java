package ires.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BibliotecaExport {
    public static void exportFile(){
        Applicazione.println("Su quale file vuoi fare l'export?");
        String filePath = Applicazione.askForString();
        Path outputFile = Paths.get( filePath );
        List<Libro> libri = Biblioteca.getLibri();

        try(BufferedWriter writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset())){
            for( Libro l : libri )
                writer.write( l.exportablePrint() + "\n\n" );
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Applicazione.println("Il file è stato correttamente esportato.");
    }
}

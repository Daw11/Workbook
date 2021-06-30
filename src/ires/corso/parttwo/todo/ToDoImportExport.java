package ires.corso.parttwo.todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

// GRUPPO 3:
public class ToDoImportExport
{
    // Gestisce import/export da file
    // Mantiene i formati di import e di export (conversione da/verso stringa)

    public static void importFile(){
        ToDoApplication.display("Su quale file vuoi fare l'import?\n");
        String filePath = ToDoApplication.askForString();
        Path inputFile = Paths.get( filePath );

        try( BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset()) ){
            String lineFromFile = "";
            while ((lineFromFile = reader.readLine()) != null) {
               // TODO: Do something
            }
        }
        catch (NoSuchFileException e){
            ToDoApplication.display("Errore, il file non esiste.\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void exportFile(){
        ToDoApplication.display("Su quale file vuoi fare l'export?\n");
        String filePath = ToDoApplication.askForString();
        Path outputFile = Paths.get( filePath );

        try(BufferedWriter writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset())){
            //TODO: do something
            //writer.append(message);
        }
        catch (NoSuchFileException e){
            ToDoApplication.display("Errore, il file non esiste.\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

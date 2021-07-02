package ires.corso.parttwo.todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// GRUPPO 3:
public class ToDoImportExport
{
    // Gestisce import/export da file
    // Mantiene i formati di import e di export (conversione da/verso stringa)

    public static void exportFile(){
        ToDoApplication.displayln("Su quale file vuoi fare l'export?");
        String filePath = ToDoApplication.askForString();
        Path outputFile = Paths.get( filePath );
        List<ToDo> toDoList = ToDoRepository.getToDoList();

        try(BufferedWriter writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset())){
            for( ToDo t : toDoList )
                writer.write( t.exportString() + "\n" );
            writer.flush();
        }
        catch (NoSuchFileException e){
            ToDoApplication.displayln("Errore, il file non esiste.");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        ToDoApplication.displayln("Il file è stato correttamente esportato.");
    }

    public static void importFile(){
        ToDoApplication.displayln("Su quale file vuoi fare l'import?");
        String filePath = ToDoApplication.askForString();
        ToDoApplication.displayln("Vuoi sovrascrivere tutti i ToDo con quelli importati? (s/n)");
        boolean overwrite = ToDoApplication.askForString().toLowerCase().equals("s");

        Path inputFile = Paths.get( filePath );
        List<List<String>> todoData = new ArrayList<>();

        try( BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset()) ){
            String lineFromFile = "";
            List<String> todoString = new ArrayList<>();
            while ((lineFromFile = reader.readLine()) != null) {
               if( lineFromFile.length() == 0 ){
                   todoData.add( todoString );
                   todoString = new ArrayList<>();
               }
               else
                   todoString.add( lineFromFile );
            }
        }
        catch (NoSuchFileException e){
            ToDoApplication.displayln("Errore, il file non esiste.");
            return;
        }
        catch (IOException e){
            e.printStackTrace();
            return;
        }

        if( overwrite )
            ToDoRepository.clear();

        todoData.forEach( ToDo::createFromString );

        ToDoApplication.displayln( "I ToDo sono stati importati." );
    }
}

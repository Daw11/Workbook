package ires.corso.parttwo.collections.courses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CourseTest {
    private final static Map<Course, Map> data = new HashMap<>();

    public static void main(String[] args) {
        Course c1 = new Course("Java", "Corso di programmazione in java", "Informatica");
        addCourse( c1 );
        addAssignment( c1, new Assignment( "Esame 1", "Basi del linguaggio" ) );
        addAssignment( c1, new Assignment( "Esame 2", "Sviluppo web" ) );
        addAssignment( c1, new Assignment( "Esame finale", "Esame finale" ) );

        Course c2 = new Course("C#", "Corso di programmazione in C#", "Informatica");
        addCourse( c2 );
        addAssignment( c2,  new Assignment( "Esame iniziale", "Basi del linguaggio" ) );
        addAssignment( c2, new Assignment( "Esame finale", "Esame pratico" ) );

        Course c3 = new Course("Sicurezza", "Corso sulla sicurezza generale", "Prevenzione infortuni");
        addCourse( c3 );
        addAssignment( c3, new Assignment( "Esame generale", "Formazione generale" ) );
        addAssignment( c3, new Assignment( "Esame specifico", "Formazione specifica" ) );

        generateStudentsAndScores();

        printCourseAverage();
        System.out.println();
        printAssignmentAverage();
    }

    private static void addCourse( Course course ){
        if( data.containsKey( course ) ) {
            System.out.printf( "Errore: il corso %s è già presente.\n", course.getTitolo() );
            return;
        }

        data.put( course, new HashMap<Assignment, Map>() );
    }

    private static Map<Assignment, Map> getAssignments( Course course ){
        if( !data.containsKey( course ) ){
            System.out.printf( "Errore: il corso %s non è presente.\n", course.getTitolo() );
            return null;
        }

        return data.get( course );
    }

    private static void addAssignment( Course course, Assignment assignment ){
        Map<Assignment, Map> assignments = getAssignments( course );

        if( assignments.containsKey( course ) ){
            System.out.printf( "Errore: l'esame %s è già presente nel corso %s.\n", assignment.getTitolo(), course.getTitolo() );
            return;
        }

        assignments.put( assignment, new HashMap<Student, Integer>() );
    }

    private static void generateStudentsAndScores(){
        ArrayList<Student> students = new ArrayList<>();
        students.add( new Student("Marco", "Rossi", "1234" ) );
        students.add( new Student("Luca", "Bianco", "22223") );
        students.add( new Student("Mario", "Verdi", "33334") );

        Random rand = new Random();

        for( Course course : data.keySet() ){
            Map<Assignment, Map> assignments = getAssignments( course );

            for( Assignment assignment : assignments.keySet() ){
                Map<Student, Integer> scores = assignments.get( assignment );

                for( Student student : students ){
                    int score = rand.nextInt( 10 ) + 1;
                    scores.put( student, score );
                }
            }
        }
    }

    private static void printCourseAverage(){
        for( Course course  : data.keySet() ){
            Map<Assignment, Map> assignments = data.get( course );
            HashMap<Student, Double> total_scores = new HashMap<>();

            for( Map<Student, Integer> scores : assignments.values() ){
                for( Student student : scores.keySet() ) {
                    double current_score;
                    if( total_scores.containsKey( student ) )
                        current_score = ( total_scores.get( student ) + scores.get( student ) ) / 2.0;
                    else
                        current_score = scores.get( student );
                    total_scores.put( student, current_score );
                }
            }

            for( Student student : total_scores.keySet() )
                System.out.printf("Lo studente %s %s ha ottenuto una media di: %f nel corso %s.\n", student.getCognome(), student.getNome(), total_scores.get( student ), course.getTitolo() );
        }
    }

    private static void printAssignmentAverage(){
        for( Course course  : data.keySet() ) {
            Map<Assignment, Map> assignments = data.get(course);

            for (Assignment assignment : assignments.keySet()) {
                Map<Student, Integer> scores = assignments.get(assignment);
                double average = 0.0;
                for (Integer i : scores.values())
                    average += i;
                average /= scores.size();

                System.out.printf("La media dei voti nell'assignment %s del corso %s è stata di %f.\n", assignment.getTitolo(), course.getTitolo(), average);
            }
        }
    }
}

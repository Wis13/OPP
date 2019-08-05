package collections.javaio;

import collections.map.treeMap.AverageStudentGrade;
import collections.map.treeMap.SubjectGrade;
import collections.map.treeMap.TreeMapRunner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class IOMain {
    public static final String FILE_NAME = "GradeBook.txt";
    public static final String BINARY_FILE = "Students.bin";
    public static final String BUFFERED_FILE = "Buffered.bin";


    public static void main(String[] args) throws IOException {
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
        Reader reader = new Reader();
        Writer writer = new Writer();
        writer.writeFile(grades, FILE_NAME);
        // reader.readFile(FILE_NAME);
        //      writeEWithFormatter();
        // processGrades(grades, writer, BINARY_FILE);
        // outputObject(reader, BINARY_FILE);

       FileUtils utils = new FileUtils();
       //utils.printNioFileDetails(FILE_NAME);
       //reader.readFileFull(FILE_NAME);
       //reader.nioReadFileWithBuffer(FILE_NAME);
       //writer.nioWriteWithBuffer(BUFFERED_FILE);
        //reader.nioReadWithStream(FILE_NAME);
        //writer.nioWriteWithStream(BUFFERED_FILE);
       // reader.nioReadWithChannel(FILE_NAME);
       // writer.nioWriteWithChannal(BUFFERED_FILE);
  //      writer.writeWithRandomAccess(FILE_NAME);
        utils.processDir();
   }

    private static void processGrades(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, Writer writer, String fileName) {
        List<Student> students = new ArrayList<>();
        for (AverageStudentGrade gradeKey : grades.keySet()) {
            students.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
        }
        writer.writeObject(students, fileName);
    }
    private static void outputObject(Reader reader, String fileName){
        List<Student> students = reader.readObject(fileName);
        for (Student student: students){
            System.out.printf("%s, %.2f, %n", student.getName(), student.getAverageGrade());
            System.out.println(student.getGrades());
        }

    }

}
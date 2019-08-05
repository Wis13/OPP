package collections.javaio;

import collections.map.treeMap.AverageStudentGrade;
import collections.map.treeMap.SubjectGrade;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static collections.javaio.IOMain.FILE_NAME;
import static java.nio.channels.FileChannel.open;
import static java.nio.file.StandardOpenOption.*;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Writer {
    public void writeWithFormatter() throws FileNotFoundException {
        Formatter formatter = new Formatter("BankAccounts.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter client id, client name, account balance:  \n ");

        int i = 0;
        while (i < 3) {
            try {
                formatter.format("%d, %s, %s, %.2f %n", scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid input");
                scanner.nextLine();
            }
        }
        formatter.close();


    }


    public void writeFile(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(FILE_NAME)) {
            for (AverageStudentGrade gradeKey : grades.keySet()) {
                writer.write("--------------------------------------------------\n");
                writer.write("Student " + gradeKey.getName() + " Average grade: " + gradeKey.getAverageGrade() + "\n");
                for (SubjectGrade grade : grades.get(gradeKey)) {
                    writer.write("Subject: " + grade.getSubject() + " Grade: " + grade.getGrade() + "\n");
                }
            }

        }

    }

    public void writeObject(List<Student> students, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            for (Student student : students) {
                out.writeObject(student);
            }
            out.writeObject(new Student("", -1, null));
        } catch (IOException e) {
            System.out.println("File cannot be opened. Program terminates");
            e.printStackTrace();
        }

    }

    public void nioWriteWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            writer.write(fileName, 0, fileName.length());
        }
    }

    public void nioWriteWithStream(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String str = "File cannot be opened. Program terminates";
        byte[] bytes = str.getBytes();
        try (OutputStream stream = Files.newOutputStream(path, CREATE, APPEND)) {
            stream.write(bytes, 0, bytes.length);

        }
    }

    public void nioWriteWithChannal(String fileName) throws IOException {
        String str = "You can also create a new file by using the newOutputStream methods, " +
                "as described in Creating and Writing a File using Stream I/O. " +
                "if you open a new output stream and close it immediately, an empty file is created.";

        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();
        byte[] bytes = str.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        channel.write(buffer);
        channel.close();
    }

    public void writeWithRandomAccess(String filename) throws IOException {
        ByteBuffer mark = ByteBuffer.wrap("Marked area ".getBytes());


        ByteBuffer buffer = ByteBuffer.allocate(10);

        Path path = Paths.get(filename);

        try (FileChannel openFile = FileChannel.open(path, READ, WRITE)) {
            int numbytes = 0;
            while (buffer.hasRemaining() && numbytes != -1) {
                numbytes = openFile.read(buffer);
            }
            openFile.position(0);
            openFile.write(mark);
            long size = openFile.size();
            openFile.position(size/2);
            mark.rewind();
            openFile.write(mark);
            openFile.position(size-1);
            mark.rewind();
            openFile.write(mark);
            mark.rewind();
            openFile.write(buffer);
        }

    }
}



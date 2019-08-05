package collections.map.treeMap;

import java.util.*;

public class TreeMapRunner {
    public static void main(String[] args) {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = createGrades();
        printGrades(grades, false);
        AverageStudentGrade border = grades.ceilingKey(new AverageStudentGrade(" ", 80));
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> scholarshipStudents = (NavigableMap<AverageStudentGrade, Set<SubjectGrade>>) grades.tailMap(border);
        System.out.println("_______________________________________________________");
        System.out.println("Scholarship students ");
        printGrades(scholarshipStudents.descendingMap(), false);
        System.out.println("Contender student ");
        AverageStudentGrade contender = grades.lowerKey(border);
        System.out.println(contender);
        System.out.println("Highest grade student");
        System.out.println(scholarshipStudents.descendingMap().firstEntry());

    }

    private static void printGrades(Map<AverageStudentGrade, Set<SubjectGrade>> grades, boolean printValue) {
        Set<AverageStudentGrade> averageGrades = grades.keySet();
        for (AverageStudentGrade gr : averageGrades) {
            System.out.println(gr);
            if (printValue) {
                System.out.println(grades.get(gr));
            }
        }
    }


    public static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades() {

        Set<SubjectGrade> alexGrade = new HashSet<>();
        alexGrade.add(new SubjectGrade("Mathematics", 89));
        alexGrade.add(new SubjectGrade("Physics", 65));
        alexGrade.add(new SubjectGrade("History", 95));
        alexGrade.add(new SubjectGrade("Literature", 90));
        alexGrade.add(new SubjectGrade("Chemistry", 75));

        Set<SubjectGrade> jamesGrade = new HashSet<>();
        jamesGrade.add(new SubjectGrade("Mathematics", 75));
        jamesGrade.add(new SubjectGrade("Physics", 80));
        jamesGrade.add(new SubjectGrade("History", 55));
        jamesGrade.add(new SubjectGrade("Literature", 70));
        jamesGrade.add(new SubjectGrade("Chemistry", 80));

        Set<SubjectGrade> antonyGrade = new HashSet<>();
        antonyGrade.add(new SubjectGrade("Mathematics", 93));
        antonyGrade.add(new SubjectGrade("Physics", 91));
        antonyGrade.add(new SubjectGrade("History", 82));
        antonyGrade.add(new SubjectGrade("Literature", 78));
        antonyGrade.add(new SubjectGrade("Chemistry", 88));

        Set<SubjectGrade> victoriaGrade = new HashSet<>();
        victoriaGrade.add(new SubjectGrade("Mathematics", 73));
        victoriaGrade.add(new SubjectGrade("Physics", 65));
        victoriaGrade.add(new SubjectGrade("History", 75));
        victoriaGrade.add(new SubjectGrade("Literature", 66));
        victoriaGrade.add(new SubjectGrade("Chemistry", 50));

        Set<SubjectGrade> alinaGrade = new HashSet<>();
        alinaGrade.add(new SubjectGrade("Mathematics", 90));
        alinaGrade.add(new SubjectGrade("Physics", 70));
        alinaGrade.add(new SubjectGrade("History", 78));
        alinaGrade.add(new SubjectGrade("Literature", 88));
        alinaGrade.add(new SubjectGrade("Chemistry", 89));


        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new AverageStudentGrade("Alex", calcAverage(alexGrade)), alexGrade);
        map.put(new AverageStudentGrade("James", calcAverage(jamesGrade)), jamesGrade);
        map.put(new AverageStudentGrade("Antony", calcAverage(antonyGrade)), antonyGrade);
        map.put(new AverageStudentGrade("Victoria", calcAverage(victoriaGrade)), victoriaGrade);
        map.put(new AverageStudentGrade("Alina", calcAverage(alinaGrade)), alinaGrade);

        return map;

    }

    private static float calcAverage(Set<SubjectGrade> grades) {
        float sum = 0f;
        for (SubjectGrade sg : grades) {
            sum += sg.getGrade();
        }
        return sum / grades.size();

    }
}

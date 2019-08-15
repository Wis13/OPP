package collections.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

public class StreamOverviewMain {

    private static List<Employee> employeeList = new ArrayList<>();
    private static List<Employee> secondList = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) throws IOException {
        employeeList.add(new Employee(3,"Zina", "Orange", 63000, "IT"));
        employeeList.add(new Employee(1, "Alex", "Black", 50000,"Finance"));
        employeeList.add(new Employee(2, "John", "Green", 75000, "Finance"));
        employeeList.add(new Employee(6, "Sam", "Brown", 80000, "IT"));
        employeeList.add(new Employee(10, "Mike", "Yellow", 60000, "Finance"));
        employeeList.add(new Employee(11, "Victoria", "Pink", 75000,"Finance"));
        employeeList.add(new Employee(16, "Sean", "Magneta", 80000, "IT"));
        employeeList.add(new Employee(19, "Kate", "Black", 88000, "IT"));
//        employeeList.add(new Employee(9, "Tony", "Grey", 90000));
//        employeeList.add(new Employee(10, "Mike", "Yellow", 60000));
//        employeeList.add(new Employee(11, "Victoria", "Pink", 75000));
        secondList.add(new Employee(6, "Sam", "Brown", 80000, "Finance"));
        secondList.add(new Employee(9, "Tony", "Grey", 90000, "Finance"));
        secondList.add(new Employee(2, "John", "Green", 75000, "IT"));
        secondList.add(new Employee(9, "Tony", "Grey", 90000, "Finance"));
        secondList.add(new Employee(10, "Mike", "Yellow", 60000, "IT"));
        secondList.add(new Employee(1, "Alex", "Black", 50000, "Finance"));
        secondList.add(new Employee(11, "Victoria", "Pink", 75000,"Finance"));
        secondList.add(new Employee(16, "Sean", "Magneta", 80000, "IT"));
        secondList.add(new Employee(19, "Kate", "Black", 88000, "IT"));

//        testStreamFromList();
//        testStreamFromFile();
//        testSortAndReduce();
//        partitionByIncome();
//        groupByCriterion(Employee::getDepartment);

        Supplier<Long> supplier = new Supplier<Long>() {
            private long previous = 0;
            private long current = 1;
            @Override
            public Long get() {
                long next = previous + current;
                previous = current;
                current = next;
                return current;
            }
        };

        testStreamGenerator(91, supplier);
//        testStreamIterator(10);
//        testParalellStream();

    }
    private static void testParalellStream() throws IOException {
        employeeList
                .parallelStream()
                .map(Employee::getId)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        Files.lines(Paths.get("word.txt"))
                .parallel()
                .sorted();
    }

    private static void testStreamIterator(int limit){
        Stream.iterate(1, e-> e*3).limit(limit).forEach(System.out::println);
    }

    private static <T> void testStreamGenerator(int limit, Supplier<T> supplier) {
        Stream.generate(supplier).limit(limit).forEach(System.out::println);

    }

    private static <R> void groupByCriterion(Function<Employee, R> function){
        Map<R, List<Employee>> collectedEmployee = employeeList.stream().collect(Collectors.groupingBy(function));
        collectedEmployee.keySet().stream().forEach(e-> System.out.println(e + "\n" + collectedEmployee.get(e)));
    }

    private static void partitionByIncome(){
        Map<Boolean, List<Employee>> collectedEmployee = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 70000));
        System.out.println("Poor employees ");
        System.out.println(collectedEmployee.get(false));
        System.out.println("Rich employees ");
        System.out.println(collectedEmployee.get(true));

    }

    private static void testSortAndReduce(){
        Employee employee = employeeList.stream()
                .max((e1, e2) -> e1.getId() - e2.getId()).get();

        employeeList.stream()
                .sorted((s1,  s2)->s1.getFirstname().compareTo(s2.getFirstname()))
                .collect(Collectors.toList()).forEach(System.out::println);

        Employee identity = new Employee(0,"","",0, "");
        Employee reducedEmployee = employeeList.stream()
                .reduce(identity, (e1, e2) -> {
                    e1.setId(e1.getId() + e2.getId());
                    e1.setSalary(e1.getSalary() + e2.getSalary());
                    return e1;

                });
        System.out.println(reducedEmployee);

    }

    private static void testStreamFromList() {
        employeeList.stream()
                .filter(e -> e.getSalary() > 60000)
                .filter(e -> e.getId() < 10)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("\n");

        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        Optional<Employee> first = Stream.of(ids)
                .map(StreamOverviewMain::findById)
                .filter(Objects::nonNull)
                .findFirst();
        System.out.println(first);

        Stream.of(ids)
                .map(StreamOverviewMain::findById)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .max();
        List<List<Employee>> department = new ArrayList<>();
        department.add(employeeList);
        department.add(secondList);

        department.stream().flatMap(l->l.stream().map(e->e.getFirstname())).forEach(System.out::println);

//        int sum = 0;
//        Consumer<Integer> c = e->e=e*2;
//        Stream.of(ids)
//                .forEach(c);

    }

    private static void testStreamFromFile() throws IOException {
        Files.lines(Paths.get("word.txt"))
                .filter(e -> e.length() > 4)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }

    private static Employee findById(int id) {
        if (employeeMap == null) {
            employeeMap = employeeList.stream().distinct().collect(Collectors.toMap(Employee::getId, e -> e));
        }
        return employeeMap.get(id);
    }
}

package lambdas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HigerOrderFunctionExample {
    public static void main(String[] args) {
        List<RichPerson> richPeople = new ArrayList<>();

        richPeople.add(new RichPerson("Alex", "Black", 50000, 25));
        richPeople.add(new RichPerson("John", "Green", 75000, 35));
        richPeople.add(new RichPerson("Sam", "Brown", 80000, 40));
        richPeople.add(new RichPerson("Tony", "Grey", 90000, 50));

        testPredicate(richPeople);
        testFunction(richPeople);
        testConsumer(richPeople);
    }
    private static void testPredicate(List<RichPerson> richPeople){
        System.out.println("Testing predicate...");
        Predicate<RichPerson> isRich = x->x.getSalary()>=75000;
        Predicate<RichPerson> isYoung = y ->y.getAge()<=40;
        System.out.println("Is rich and young ");
        findAll(richPeople, isRich.and(isYoung)).forEach(System.out::println);
        System.out.println("Is rich and young ");
        findAll(richPeople, isRich.or(isYoung)).forEach(System.out::println);
        System.out.println("Is rich and young ");
        findAll(richPeople, isYoung.negate()).forEach(System.out::println);
    }
    private static <T> List<T> findAll(List<T> elements, Predicate<T> predicate){
        List<T> filteredList = new ArrayList<>();
        for (T element: elements){
            if (predicate.test(element)){
                filteredList.add(element);
            }
        }
        return filteredList;
    }
    private static void testFunction(List<RichPerson> richPeople){
        System.out.println("Testing function ...");
//        f1.compose(f2) ==> f1(f2(x));
//        f1(f2(x)) < f1.andThen(f2)--;
//        Function.identity();
        Function<RichPerson, String> name = x->x.getFirstName()+ " " +x.getLastName();
        Function<String, String> sayHello = y->"Hello " + y;
        Function<RichPerson, String> composeFunction = sayHello.compose(name);
        List<String> transformmedList = transform(richPeople, composeFunction);

        Function<String, String> exlaim = z->z + "!!!";
        Function<String, String> toUpper = String::toUpperCase;

        transform(transformmedList, compose(toUpper, exlaim)).forEach(System.out::println);
    }

    private static <T> Function<T, T>compose(Function<T, T>... functions){
        Function<T, T> result = Function.identity();
        for (Function<T,T> f:functions){
            result = result.andThen(f);
        }
        return result;
    }
    private static <T, R> List<R> transform(List<T> elements, Function<T, R> function){
        List<R> list = new ArrayList<>();
        for (T elem: elements){
            list.add(function.apply(elem));
        }
        return list;
    }
    private static void testConsumer(List<RichPerson> richPeople){
        System.out.println("Testing consumer ...");
//        f1.andThen(f2(x)) -> f1(x) andThen f2(x);
        Consumer<RichPerson> rise = x->x.setSalary(x.getSalary()*11/10);
        processList(richPeople,rise.andThen(System.out::println));
    }
    private static <T> void processList(List<T> elements, Consumer<T> consumer){
        for (T e :elements){
            consumer.accept(e);
        }
    }

}


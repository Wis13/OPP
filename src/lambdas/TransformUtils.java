package lambdas;

public class TransformUtils<T> {
    T transform(T t, TransFormable<T> function){
        return function.transform(t);
    }

    static String explain(String s){
        return s.toUpperCase() + "!!!";
    }
}

package lambdas;

@FunctionalInterface
public interface TransFormable<T> {
    T transform (T t);
}

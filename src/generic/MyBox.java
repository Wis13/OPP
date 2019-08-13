package generic;

public class MyBox<X> {


    public <T> MyBox(T param){
        System.out.println(param.getClass().getSimpleName());
    }
    public static <U> U returnValue(U param){
        return param;
    }
}

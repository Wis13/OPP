package generic;

import java.util.ArrayList;
import java.util.List;

public interface BoxList<E,T> extends List<E> {
    T calcSum(E elem1, T elem2);

}

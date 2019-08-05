package collections.autoboxing;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ColleectionMain {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        list.add(23);


    String[] colors = {"yellow", "green", "blue"};

    LinkedList<String> ll = new LinkedList<>(Arrays.asList(colors));
    ll.add("black");

    colors = ll.toArray(new String[ll.size()]);

    for (int i = 0; i<colors.length; i++){
        System.out.println(colors[i]);
    }
    }
}

package backjoon._03_loop;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5));


        HashSet<Integer> set2 = (HashSet<Integer>) set.clone();
        set2.add(6);

        System.out.println("SET1");
        set.stream().mapToInt(x->x).forEach(System.out::println);
        System.out.println("SET2");
        set2.stream().mapToInt(x->x).forEach(System.out::println);
    }
}

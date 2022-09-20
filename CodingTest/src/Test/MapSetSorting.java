package Test;

import java.util.*;

public class MapSetSorting {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(3);
        set.add(1);
        set.add(2);
        set.add(5);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {

        }

        List<Integer> temp = new ArrayList<>();
        for (Integer integer : set) {
            temp.add(integer);
        }
        Collections.sort(temp);


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(5);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        int[] arr = {1, 2, 5, 4, 3};
        System.out.println("array : "+Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("array : "+Arrays.toString(arr));
    }
}

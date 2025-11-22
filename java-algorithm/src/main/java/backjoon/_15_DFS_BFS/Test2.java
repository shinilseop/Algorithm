package backjoon._15_DFS_BFS;

import java.util.LinkedList;

public class Test2 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // ConcurrentModificationException
//        for (Integer num : list) {
//            System.out.println(num);
//            if (num == 1) {
//                list.remove(list.indexOf(2));
//            }
//        }

    }
}

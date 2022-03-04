package programmers.high_scores._02_stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex01 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();


        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                q.offer((100 - progresses[i]) / speeds[i]);
                System.out.println(i + " : " + (100 - progresses[i]) / speeds[i]);
            } else {
                q.offer(((100 - progresses[i]) / speeds[i]) + 1);
                System.out.println(i + " : " + ((100 - progresses[i]) / speeds[i] + 1));
            }
        }

        int cnt = 0, maxDay = q.peek();
        ArrayList<Integer> ansTmp = new ArrayList<>();
        while (!q.isEmpty()) {
            int num = q.poll();

            if (maxDay < num) {
                ansTmp.add(cnt);
                maxDay = num;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        ansTmp.add(cnt);

        return arrayslistToArray(ansTmp);
    }

    public static int[] arrayslistToArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55}, speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
}

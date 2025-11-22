package programmers.high_scores._04_sort;

import java.util.Arrays;

public class Ex01 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int len = commands[i][1] - commands[i][0];
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            System.out.println(Arrays.toString(tmp));
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }

        return answer;
    }
}

package programmers.high_scores._05_bruteforce;

import java.util.Arrays;

public class Ex03_past {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int num = brown / 2;
        for (int i = 1; i < num; i++) {
            if ((num - 2 - i) * i == yellow) {
                answer[0] = num - i;
                answer[1] = i + 2;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(117, 27)));
    }
}

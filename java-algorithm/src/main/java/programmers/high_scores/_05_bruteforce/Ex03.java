package programmers.high_scores._05_bruteforce;

import java.util.Arrays;

public class Ex03 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        boolean isFind = false;
        int sum = brown+yellow;
        int widthStart = (int)Math.sqrt(sum);
        for (int i = widthStart; ; i++) {
            for (int j = 1; j <= i; j++) {
                if (i * j == brown + yellow) {
                    int gap = 2;
                    while (j - gap > 0) {
                        if ((i - gap) * (j - gap) == yellow) {
                            isFind=true;
                            answer[0] = i;
                            answer[1] = j;
                        }
                        gap+=2;
                    }
                }
                if (isFind) {
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(24, 24)));
        System.out.println(Arrays.toString(solution(132, 1015)));
        System.out.println(Arrays.toString(solution(96,21)));
    }
}

package programmers.high_scores._06_greedy;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Ex03 {
    public static String solution(String number, int k) {
        StringBuffer sb = new StringBuffer(number);

        int idx=0, change = 0;
        while (change != k) {
            if (idx == sb.length()-1) {
                break;
            } else if (sb.charAt(idx) < sb.charAt(idx + 1)) {
                sb.deleteCharAt(idx);
                idx = idx==0?0:idx-1;
                change++;
            } else {
                idx++;
            }
        }

        return sb.delete(sb.length()-(k-change), sb.length()).toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
}

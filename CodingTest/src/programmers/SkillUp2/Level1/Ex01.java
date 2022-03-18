package programmers.SkillUp2.Level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {
    public int[] solution(long n) {

        StringBuffer sb = new StringBuffer(String.valueOf(n));
        char[] arr = sb.reverse().toString().toCharArray();
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i] - '0';
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }
}

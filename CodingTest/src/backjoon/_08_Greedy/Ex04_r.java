package backjoon._08_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex04_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] num = Arrays.stream(input.split("\\+|-")).mapToInt(s->Integer.parseInt(s)).toArray();
        String oper = input.replaceAll("[0-9]", "");

        int sum = num[0];
        boolean isMinus = false;
        for (int i = 1; i < num.length; i++) {
            if (isMinus || oper.charAt(i - 1) == '-') {
                isMinus=true;
                sum-=num[i];
            } else {
                sum+=num[i];
            }
        }

        System.out.println(sum);
    }
}

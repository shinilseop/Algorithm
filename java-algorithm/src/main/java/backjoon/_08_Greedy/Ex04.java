package backjoon._08_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String func = br.readLine();
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> oper = new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < func.length(); i++) {
            char ch = func.charAt(i);
            if (ch == '+') {
                nums.add(Integer.parseInt(sb.toString()));
                oper.add('+');
                sb=new StringBuffer();
            } else if (ch == '-') {
                nums.add(Integer.parseInt(sb.toString()));
                oper.add('-');
                sb=new StringBuffer();
            } else {
                sb.append(ch);
            }
        }
        nums.add(Integer.parseInt(sb.toString()));

        int sum = nums.get(0);
        boolean isMinus = false;
        for (int i = 0; i < oper.size(); i++) {
            if (oper.get(i) == '-') {
                isMinus = true;
            }

            if (isMinus) {
                sum -= nums.get(i+1);
            } else {
                sum += nums.get(i+1);
            }
        }

        System.out.println(sum);
    }
}

package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(loop*20);

        while (loop-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            int GCD = 1;
            int num1Tmp = num1, num2Tmp = num2;
            for (int i = 2; i <= Math.min(num1Tmp, num2Tmp); i++) {
//            System.out.println(i+" "+num1Tmp+" "+num2Tmp);
                if (num1Tmp % i == 0 && num2Tmp % i == 0) {
                    num1Tmp /= i;
                    num2Tmp /= i;
                    GCD *= i;
                    i--;
                }
            }

            sb.append(((num1*num2)/GCD)).append("\n");
        }

        System.out.print(sb.toString());
    }
}

package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex05 {
    public static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
        }

        return num1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        int max = 0;
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for (int i = size - 1; i > 0; i--) {
            arr[i] -= arr[i-1];
        }

        int GCD = arr[1];
        for (int i = 2; i < size; i++) {
            GCD = gcd(GCD, arr[i]);
        }

        for (int i = 2; i < GCD; i++) {
            if (GCD % i == 0) {
                sb.append(i).append(' ');
            }
        }
        sb.append(GCD);
        System.out.println(sb.toString());
    }
}

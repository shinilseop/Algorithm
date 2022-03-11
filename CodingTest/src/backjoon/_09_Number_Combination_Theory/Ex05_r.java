package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex05_r {

    public static int LCM(int gcd, int num1, int num2) {
        return (num1 * num2) / gcd;
    }

    public static int GCD(int num1, int num2) {
        while (num2 != 0) {
            int tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }

        return num1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i]-=arr[i-1];
        }

        int gcd = arr[1];
        for (int i = 2; i < size; i++) {
            gcd = GCD(gcd, arr[i]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 2; i <= gcd; i++) {
            if(gcd%i==0) sb.append(i).append(' ');
        }

        System.out.println(sb.toString().strip());
    }
}

package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex06 {
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
        int size = Integer.parseInt(br.readLine());

        int arr[] = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer(size * 3 * 10);
        for (int i = 1; i < size; i++) {
            int GCD = gcd(arr[0], arr[i]);
            sb.append(arr[0] / GCD).append('/').append(arr[i] / GCD).append('\n');
        }
        System.out.print(sb.toString());
    }
}

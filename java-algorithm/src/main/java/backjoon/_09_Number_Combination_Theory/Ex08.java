package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex08 {
    static boolean[] primeNum;

    public static ArrayList<Integer> factorization(int num) {
        ArrayList<Integer> factor = new ArrayList<>();

        for (int i = 2; i <= num; i++) {
            if (primeNum[i] && num % i == 0) {
                factor.add(i);
                num /= i;
                i--;
            }
        }

        return factor;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        primeNum = new boolean[1001];
        Arrays.fill(primeNum, true);
        for (int i = 2; i < primeNum.length; i++) {
            if (!primeNum[i]) {
                for (int j = i + i; j < primeNum.length; j += i) {
                    primeNum[i] = false;
                }
            }
        }

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        Arrays.fill(nums, 1);
        for (int i = k + 1; i <= n; i++) {
            nums[i] = i;
        }

//        System.out.println(Arrays.toString(nums));
        for (int i = 2; i <= n - k; i++) {
            ArrayList<Integer> factorList = factorization(i);
            for (Integer num : factorList) {
                for (int j = k + 1; j <= n; j++) {
                    if (nums[j] % num == 0) {
                        nums[j] /= num;
                        break;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(nums));

        int result = 1;
        for (int i = k + 1; i <= n; i++) {
            result = (result * nums[i]) % 10007;
        }
        System.out.println(result);
    }
}

package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k > n) {
            System.out.println(0);
        } else {
            int max = Math.max(n, k);
            long factorial = 1, kFac = 1, nFac = 1,n_kFac = 1;
            for (int i = 2; i <= max; i++) {
                factorial *= i;
                if (i == k) {
                    kFac = factorial;
                }
                if (i == n) {
                    nFac = factorial;
                }
                if (i == n - k) {
                    n_kFac = factorial;
                }
            }

            System.out.println(nFac+" "+kFac+" "+n_kFac);
            System.out.println((nFac/(kFac*n_kFac)));
        }
    }
}

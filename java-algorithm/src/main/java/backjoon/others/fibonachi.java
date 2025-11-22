package backjoon.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonachi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(getFibobachi(N));
    }

    private static int getFibobachi(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return getFibobachi(n - 1) + getFibobachi(n - 2);
    }
}

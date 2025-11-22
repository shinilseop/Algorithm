package backjoon._03_loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    static int fibonachi(int n) {
        if(n==0)
            return 0;
        if(n==1||n==2)
            return 1;

        return fibonachi(n - 1) + fibonachi(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(fibonachi(num));
    }
}

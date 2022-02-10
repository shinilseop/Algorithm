package backjoon._03_loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {
    static int factorial(int n) {
        if(n==1 || n==0)
            return 1;

        return n*factorial(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(factorial(num));
    }
}

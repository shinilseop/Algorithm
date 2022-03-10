package backjoon._01_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int lo = 1, hi = 1, add = 1;
        while (hi < num) {
            lo += add;
            hi += (++add);
        }

        int up = num - lo + 1, down = add - (num -  lo);
        if (add % 2 == 0) {
            System.out.print(up + "/" + down);
        } else {
            System.out.print(down + "/" + up);
        }
    }
}

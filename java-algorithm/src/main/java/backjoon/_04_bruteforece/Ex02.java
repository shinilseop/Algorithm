package backjoon._04_bruteforece;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int min = 0;
        for (int i = num - 1; i >= 1; i--) {
            int partSum = i;
            int divNum = i;
            while (divNum > 0) {
//                System.out.println("(" + i + ") partSum : " + partSum + ", divNum : " + divNum);
                partSum += divNum % 10;
                divNum = divNum / 10;
            }

            if (partSum == num) {
//                System.out.println("SAME! " + partSum + " " + i);
                min = i;
            }
        }

        System.out.println(min);
    }
}

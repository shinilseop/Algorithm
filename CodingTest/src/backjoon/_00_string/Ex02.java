package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split("");
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(num[i]);
        }

        System.out.println(sum);
    }
}

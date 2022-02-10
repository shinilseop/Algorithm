package backjoon._02_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double r = Integer.parseInt(br.readLine());

        System.out.printf("%.6f\n", r*r*Math.PI);
        System.out.printf("%.6f", r*r*2);
    }
}

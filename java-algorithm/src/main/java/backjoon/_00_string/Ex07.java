package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuffer num1 = new StringBuffer(st.nextToken());
        StringBuffer num2 = new StringBuffer(st.nextToken());

        int max = Math.max(Integer.parseInt(num1.reverse().toString()), Integer.parseInt(num2.reverse().toString()));
        System.out.println(max);
    }
}

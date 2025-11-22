package step._1_input_and_calculate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5_1008_ADivB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        System.out.println(a/b);
    }
}

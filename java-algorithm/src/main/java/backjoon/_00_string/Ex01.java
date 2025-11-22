package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char ch = br.readLine().charAt(0);

        System.out.println((int)ch);
    }
}

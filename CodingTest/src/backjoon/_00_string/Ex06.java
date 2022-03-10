package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine().strip();
        if (sentence.length() == 0) {
            System.out.println(0);
        } else {
            char[] words = sentence.toCharArray();
            int cnt = 1;
            for (int i = 0; i < words.length; i++) {
                if(words[i]==' ') cnt++;
            }
            System.out.println(cnt);
        }
    }
}

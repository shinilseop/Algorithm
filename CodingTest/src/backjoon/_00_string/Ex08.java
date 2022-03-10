package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'A';
            int num = 0, exceptNum = 0;;
            for (int j = 2; j <= 9; j++) {
                if (j == 7 || j == 9) {
                    exceptNum++;
                }

                if (ch < (j - 1) * 3 + exceptNum) {
                    num = j + 1;
                    break;
                }
            }

            sum += num;
        }

        System.out.println(sum);
    }
}

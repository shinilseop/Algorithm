package backjoon2.step._6_advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4_10988_check_pelindrom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.length() == 1) {
            System.out.println(1);
        }

        char[] inputs = input.toCharArray();

        for (int i = 0; i < inputs.length / 2; i++) {
            if (inputs[i] != inputs[inputs.length - 1 - i]) {
                System.out.println(0);
                break;
            }

            if (i == inputs.length / 2 - 1) {
                System.out.println(1);
                break;
            }
        }
    }
}

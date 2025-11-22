package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int cnt = T;
        while (T-- > 0) {
            String word = br.readLine();
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);
                boolean success = true;
                if (key != ' ') {
                    boolean isDiff = false;
                    for (int j = i + 1; j < word.length(); j++) {
                        if (isDiff & key == word.charAt(j)) {
                            word.replaceAll(String.valueOf(key), " ");
                            success=false;
                            break;
                        } else if (!isDiff & key != word.charAt(j)) {
                            isDiff = true;
                        }
                    }
                }

                if (!success) {
                    cnt--;
                    break;
                }
            }
        }


        System.out.print(cnt);
    }
}

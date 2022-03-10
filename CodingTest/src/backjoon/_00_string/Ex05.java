package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toLowerCase(Locale.ROOT).toCharArray();
        int[] cnt = new int[26];

        for (int i = 0; i < word.length; i++) {
            cnt[word[i] - 'a']++;
        }

        int maxIdx = -1, maxValue = -1;
        for (int i = 0; i < cnt.length; i++) {
            if (maxValue < cnt[i]) {
                maxValue = cnt[i];
                maxIdx = i;
            } else if (maxValue == cnt[i]) {
                maxIdx=-1;
            }
        }

        char ch =  ' ';
        if (maxIdx == -1) {
            ch = '?';
        } else {
            ch = (char)(maxIdx+'A');
        }

        System.out.print(ch);
    }
}

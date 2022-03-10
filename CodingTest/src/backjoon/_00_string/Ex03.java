package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        int[] alphabetIdx = new int[26];
        Arrays.fill(alphabetIdx, -1);

        for (int i = 0; i < word.length; i++) {
            if(alphabetIdx[word[i]-'a']==-1)
                alphabetIdx[word[i]-'a'] = i;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < alphabetIdx.length; i++) {
            sb.append(alphabetIdx[i]).append(' ');
        }

        System.out.println(sb.toString());
    }
}

package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Ex09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> croatia = new HashSet<>();
        croatia.add("c=");
        croatia.add("c-");
        croatia.add("dz=");
        croatia.add("d-");
        croatia.add("lj");
        croatia.add("nj");
        croatia.add("s=");
        croatia.add("z=");

        String word = br.readLine();
        int cnt = 0, i = 0;
        while (i <= word.length()-3) {
            if (croatia.contains(word.substring(i, i + 3))) {
                cnt++;
                i+=3;
            } else if (croatia.contains(word.substring(i, i + 2))) {
                cnt++;
                i+=2;
            } else {
                cnt++;
                i++;
            }
        }

        if (i == word.length() - 2) {
            if (croatia.contains(word.substring(i, i + 2))) {
                cnt++;
                i+=2;
            } else {
                cnt+=2;
                i+=2;
            }
        } else if (i == word.length() - 1){
            cnt++;
        }

        System.out.println(cnt);
    }
}

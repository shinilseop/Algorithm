package Test_Result.Software_Maestro_1._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex03 {
    // (a*n+b)%26 => 암호키 복호화 하기

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(i, String.valueOf(('a'+i)));
        }

        String word = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            int wordNum = word.charAt(i) - 'a' - b;

            while (wordNum % a != 0) {
                wordNum += 26;
            }

            char ch = (char)((wordNum/a) + 'a');
            sb.append(ch);
        }

        System.out.print(sb.toString().strip());
    }
}

package backjoon._02_math2;

import java.io.*;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int divNum = 2;
        while (num>1) {
            if ((num % divNum) == 0) {
                System.out.println(divNum);
                num /= divNum;
                continue;
            }

            divNum++;
        }
    }
}

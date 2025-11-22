package backjoon._02_math2;

import java.io.*;
import java.util.*;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prime_cnt = 0;
        loop : while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if(num==1) {
                continue;
            } else if(num==2){
                prime_cnt++;
            } else {
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        continue loop;
                    }
                }

                prime_cnt++;
            }
        }

        System.out.println(prime_cnt);
    }
}

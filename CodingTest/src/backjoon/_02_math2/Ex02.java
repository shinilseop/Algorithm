package backjoon._02_math2;

import java.io.*;
import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> primenum = new ArrayList<>();
        loop : for (int i = m; i <= n; i++) {
            if(i==1){
                continue;
            } else if (i == 2) {
                primenum.add(i);
            } else {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        continue loop;
                    }
                }

                primenum.add(i);
            }
        }

        if(primenum.size()==0){
            System.out.println(-1);
        } else {
            System.out.println(primenum.stream().mapToInt(num -> num).sum());
            System.out.println(primenum.get(0));
        }
    }
}

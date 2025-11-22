package backjoon._02_math2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if(m==1){
            if(n==1){
                return;
            }
            m+=1;
        }
        StringBuffer sb = new StringBuffer(n-m);
        ArrayList<Integer> primeNum = new ArrayList<>();
        boolean normalNum[] = new boolean[n + 1];
        for (int i = 2; i < normalNum.length; i++) {
            if(!normalNum[i]){
                if(i>=m){
                    sb.append(i+"\n");
                }
                for (int j = i + i; j < normalNum.length; j+=i) {
                    normalNum[j] = true;
                }
            }
        }

        System.out.println(sb.toString());
//        primeNum.stream().mapToInt(x->x).forEach(System.out::println);
    }
}

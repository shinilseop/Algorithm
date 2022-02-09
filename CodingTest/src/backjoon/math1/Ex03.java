package backjoon.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for (int i = 1, sum = 0; ; i++) {
            sum+=i;
            if (input <= sum) {
                int diff = input - (sum - i);
                if(i % 2 == 0){
                    System.out.println(diff+"/"+(i-diff+1));
                    break;
                } else {
                    System.out.println((i-diff+1)+"/"+diff);
                    break;
                }
            }
        }
    }
}

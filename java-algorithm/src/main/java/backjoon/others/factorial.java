package backjoon.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factorial {
    static long getFactoral(int N){
        if(N == 1){
            return 1;
        }
        return N*getFactoral(N-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getFactoral(N));


    }
}

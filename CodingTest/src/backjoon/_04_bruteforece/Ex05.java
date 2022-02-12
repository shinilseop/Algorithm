package backjoon._04_bruteforece;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

<<<<<<< HEAD
        int cnt = 1;
        int number = 666;
        while (cnt<num) {
            number++;
            String tmp =  number+"";
            if(tmp.contains("666")){
                cnt++;
            }
        }

        System.out.println(number);
=======

>>>>>>> bd23a7e5ee2142fe5625bfcf3e80e729ebb60dd3
    }
}

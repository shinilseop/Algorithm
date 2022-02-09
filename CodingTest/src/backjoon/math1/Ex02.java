package backjoon.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int room_num = Integer.parseInt(br.readLine());

        if (room_num == 1)
            System.out.println(1);
        else {
//            int a = 0, b = 1, add = 2, step = 2;
//            while (true) {
////                System.out.println(a+","+b+"("+add+"):"+(6 * a + 2)+"~"+(6 * b + 1));
//                if (6 * a + 2 <= room_num && room_num <= 6 * b + 1) {
//                    System.out.println(step);
//                    break;
//                }
//
//                a = b;
//                b += add;
//                add++;
//                step++;
//            }
            int sum = 1;
            for(int i = 1;;i++){
                sum+=i*6;
                if(room_num <= sum){
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}

package backjoon._01_math1;

import java.io.*;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());

//        int pack3 = 0;
//        while(sugar > 0) {
//            if(sugar%5==0){
//                System.out.println((pack3+sugar/5));
//                return;
//            }
//
//            sugar-=3;
//            pack3++;
//        }
//
//        if(sugar == 0){
//            System.out.println(pack3);
//        } else {
//            System.out.println(-1);
//        }
//    }
        if (sugar == 1 || sugar == 2 || sugar == 4 || sugar == 7) {
            System.out.println(-1);
        } else {
            int pack5 = sugar / 5;
            int remain = sugar % 5;
            if (remain == 0) {
                System.out.println(pack5);
            } else {
                if (remain == 1 || remain == 3) {
                    System.out.println(pack5 + 1);
                } else {
                    System.out.println(pack5 + 2);
                }
            }
        }
    }
}

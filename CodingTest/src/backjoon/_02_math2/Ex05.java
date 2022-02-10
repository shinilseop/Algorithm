package backjoon._02_math2;

import java.io.*;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int primeCnt[] = new int[123457*2];
        primeCnt[1] = 0;
        boolean isNormal[] = new boolean[123457*2];
        for (int i = 2; i < isNormal.length; i++) {
            if(!isNormal[i]) {
//                System.out.println(!isNormal[i]+" "+i);
                primeCnt[i] = primeCnt[i-1]+1;
                for (int j = i + i; j < isNormal.length; j+=i) {
                    isNormal[j] = true;
                }
            } else {
//                System.out.println(!isNormal[i]+" "+i);
                primeCnt[i] = primeCnt[i-1];
            }
        }

//        for (int i = 0; i < primeCnt.length; i++) {
//            System.out.print(primeCnt[i]+" ");
//            if(i%100==0)
//                System.out.println();
//        }

//        System.out.println("WAIT");
        while (true) {
            int num = Integer.parseInt(br.readLine());

            if(num==0){
                break;
            }

            System.out.println(primeCnt[num * 2] - primeCnt[num]);
        }
    }
}

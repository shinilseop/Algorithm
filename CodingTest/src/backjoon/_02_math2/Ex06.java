package backjoon._02_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());
        int[] problem = new int[_loop];
        int max = 0;
        for (int i = 0; i < _loop; i++) {
            problem[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, problem[i]);
        }

        ArrayList<Integer> primeNum = new ArrayList<>();
        boolean isNormal[] = new boolean[max + 1];
        for (int i = 2; i < isNormal.length; i++) {
            if (!isNormal[i]) {
                primeNum.add(i);
                for (int j = i + i; j < isNormal.length; j += i) {
                    isNormal[j] = true;
                }
            }
        }

        for (int i = 0; i < problem.length; i++) {
            int idx = problem[i] % 2 == 0 ? problem[i] / 2 : problem[i] / 2 + 1;
//            System.out.println("PROBLEM : " + problem[i]+", half : "+idx);

            while (true) {
                while (true) {
                    if(!isNormal[idx]){
//                        System.out.println("FIND : "+idx);
                        break;
                    }
                    idx++;
                }

                if (!isNormal[problem[i] - idx]) {
                    System.out.println((problem[i] - idx) + " " + idx);
                    break;
                }
                idx++;
            }
        }
    }
}

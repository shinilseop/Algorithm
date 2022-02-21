package backjoon._07_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());
        int[] arr = new int[_loop];
        int max = 0;
        for (int i = 0; i < _loop; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long[] numbers = new long[max + 1];
        numbers[1] = 1;
        if (max > 1) {
            numbers[2] = 1;
            if (max > 2) {
                numbers[3] = 1;
                if (max > 3) {
                    numbers[4] = 2;
                    if(max > 4){
                        numbers[5] = 2;
                        for (int i = 6; i < numbers.length; i++) {
                            numbers[i] = numbers[i - 1] + numbers[i - 5];
                        }
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer(_loop * 2);
        for (int i = 0; i < arr.length; i++) {
            sb.append(numbers[arr[i]]).append('\n');
        }
        System.out.print(sb.toString());
    }
}

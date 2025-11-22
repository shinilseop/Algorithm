package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int originNum = 1;
        if (size == 1) {
            originNum = arr[0]*arr[0];
        } else {
            Arrays.sort(arr);

            loop:
            for (int i = 0; i < size; i++) {
                int num = arr[i];
                System.out.println(i+"번째 : "+num);
                for (int j = i-1; j >= 0; j--) {
                    System.out.println(num+"%"+arr[j]+"="+(num%arr[j]));
                    if (num % arr[j] == 0) {
                        num /= arr[j];
                        System.out.println(num);
                        if (num == 1) {
                            continue loop;
                        }
                    }
                }

                originNum *= arr[i];
                System.out.println("originNum="+originNum);
            }
        }

        System.out.println(originNum);
    }
}

package backjoon._10_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex06_twoPointer {
    public static int findLarge(int[] arr, int right) {
        for (int i = right+1; i < arr.length; i++) {
            if (arr[right] < arr[i]) {
                return i;
            }
        }

        return arr.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        int left = 0, right = 0;
        while (left < size) {
            if (left == right) {
                right = findLarge(arr, right);
            } else if (left < right) {
                if(right==size) sb.append(-1).append(' ');
                else sb.append(arr[right]).append(' ');
                left++;
                if (left < size && arr[left - 1] > arr[left]) {
//                    System.out.println(left+" == " +arr[left-1] +" > " + arr[left]);
                    right = findLarge(arr, left);
                }
            }
        }

        System.out.println(sb.toString());
    }
}

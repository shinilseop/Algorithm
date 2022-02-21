package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex07 {
    static boolean visited[];
    static int[] arr;
    static int[] oper;
    static long max, min;


    private static void makeFuncDFS(int idx, int sum) {
        if (idx == arr.length) {
//            System.out.println("result="+sum);
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        if (oper[0] > 0) {
            oper[0]--;
            makeFuncDFS(idx+1, sum+arr[idx]);
            oper[0]++;
        }
        if (oper[1] > 0) {
            oper[1]--;
            makeFuncDFS(idx+1, sum-arr[idx]);
            oper[1]++;
        }
        if (oper[2] > 0) {
            oper[2]--;
            makeFuncDFS(idx+1, sum*arr[idx]);
            oper[2]++;
        }
        if (oper[3] > 0) {
            oper[3]--;
            makeFuncDFS(idx+1, sum/arr[idx]);
            oper[3]++;
        }
    }

    private static int findMaxIdx(int start) {
        int idx = start;

        for (int i = idx; i < arr.length; i++) {
            if (arr[i] > arr[idx]) {
                idx = i;
            }
        }

        return idx;
    }

    private static int findMinIdx(int start) {
        int idx = start;

        for (int i = idx; i < arr.length; i++) {
            if (arr[i] < arr[idx]) {
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        arr = new int[_loop];
        visited = new boolean[_loop];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < _loop; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        oper = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < oper.length; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;

        makeFuncDFS(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}

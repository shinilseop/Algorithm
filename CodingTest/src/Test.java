import java.util.*;
import java.io.*;

public class Test {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[0] = i;
            count += dfs(1, arr);
        }

        System.out.println(count);
        br.close();

    }

    public static int dfs(int row, int[] arr) { //다음 줄
        int count = 0;
        //System.out.println("row = " + row);

        if (row == n) {
            //System.out.println("row = " + row);
            return 1;
        } else {
            for (int i = 0; i < n; i++) {
                //검사할 원소 값
                arr[row] = i;


//                if(check(row,i, arr)){
//                    count += dfs(row+1, arr);
//                }

                for (int j = 0; j < row; j++) {
                    //arr 의 있던 친구들 위치
                    if (i == arr[j]) {
                        break;
                    }
                    if (Math.abs(j - row) == Math.abs(arr[j] - i)) break;
                    if (j == row - 1) count += dfs(row + 1, arr);
                }
                for (int j = 0; j < row; j++) {
                    //arr 의 있던 친구들 위치
                    if (i == arr[j]) {
                        break;
                    }
                    if (Math.abs(j - row) == Math.abs(arr[j] - i)) break;
                    count += dfs(row + 1, arr);
                }
            }
        }
        return count;
    }

    static boolean check(int row, int i, int[] arr) {
        for (int j = 0; j < row; j++) {
            //arr 의 있던 친구들 위치
            if (i == arr[j]) {
                return false;
            }
            if (Math.abs(j - row) == Math.abs(arr[j] - i)) return false; //대각선
        }

        return true;
    }
}

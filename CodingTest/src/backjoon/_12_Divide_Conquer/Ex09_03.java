package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex09_03 {
    static int size;
    static int[] hist;
    static long[] visited;

    public static long divideConquer(int start, long minHeight) {
        long sum = 0;
//        System.out.println("START:"+start+", min:"+minHeight);

        long width = 1, height = hist[start];
        for (int i = start + 1; i < size; i++) {
            if (hist[i] <= minHeight) {
                break;
            }

            if (height == hist[i]) {
                width++;
            } else if (height < hist[i]) {
                width++;
                if(visited[i] < hist[i]){
                    sum = Math.max(sum, divideConquer(i, height));
                }
            } else if (height > hist[i]) {
                sum = Math.max(sum, height * width);
                height = hist[i];
                width++;
            }

            visited[i] = height;
        }

        sum = Math.max(sum, height * width);

//        System.out.println(Arrays.toString(visited));

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            size = Integer.parseInt(st.nextToken());
            visited=new long[size];
            if (size == 0) {
                break;
            }

            hist = new int[size];
            for (int i = 0; i < size; i++) {
                hist[i] = Integer.parseInt(st.nextToken());
            }

            long sum = divideConquer(0, 0);

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}

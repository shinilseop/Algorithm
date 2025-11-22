package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex09_02 {
    static int size;
    static int[] hist;
    static long[] visited;

    public static long divideConquer(int start, long minHeight) {
        long sum = 0;

        long width = 1, height = hist[start];
        for (int i = start + 1; i < size; i++) {
            if (hist[i] <= minHeight) {
                break;
            }

            if (height == hist[i]) {
                width++;
            } else if (height < hist[i]) {
                width++;
                divideConquer(i, height);
            } else if (height > hist[i]) {
                sum = Math.max(sum, height * width);
                height = hist[i];
                width++;
            }
        }

        sum = Math.max(sum, height * width);

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

            ArrayList<Integer> visitIdx = new ArrayList<>();
            long sum = 0, width = 1, height = hist[0];
            for (int i = 1; i < size; i++) {
                visited[i] = height;

                if (height == hist[i]) {
                    width++;
                } else if (height < hist[i]) {
                    width++;
                    visitIdx.add(i);
                } else if (height > hist[i]) {
                    sum = Math.max(sum, height * width);
                    height = hist[i];
                    width++;
                }
            }
            sum = Math.max(sum, height * width);
//            System.out.println();
//            System.out.println(Arrays.toString(visited));
//            System.out.print("visitIDX : ");
//            visitIdx.stream().forEach(x->System.out.print(x+" "));
//            System.out.print("sum : "+sum);
//            System.out.println();

            for (Integer idx : visitIdx) {
                width = 1;
                height = hist[idx];
                for (int i = idx+1; i < size; i++) {
                    if (visited[i] >= height) {
                        break;
                    }
                    visited[i] = height;

                    if (height == hist[i]) {
                        width++;
                    } else if (height < hist[i]) {
                        width++;
                    } else if (height > hist[i]) {
                        sum = Math.max(sum, height * width);
                        height = hist[i];
                        width++;
                    }
                }

                sum = Math.max(sum, height * width);

//                System.out.println();
//                System.out.println(Arrays.toString(visited));
//                System.out.print("visitIDX : ");
//                visitIdx.stream().forEach(x->System.out.print(x+" "));
//                System.out.print("sum : "+sum);
//                System.out.println();
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}

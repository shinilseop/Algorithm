package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex09_04_DC {
    static int size;
    static int[] hist;
    static long[] visited;

    public static long divideConquer(int from, int to) {
        if (from == to) {
            return hist[from];
        }

        int mid = (from + to) / 2;
        long height = Math.min(hist[mid], hist[mid+1]);
        long width = 2;
        long sum = Math.max(height * width, Math.max(divideConquer(from, mid), divideConquer(mid + 1, to)));
        int left = mid, right = mid + 1;
        while (from < left || right < to) {
            if (left == from) {
                right++;
                height = Math.min(height, hist[right]);
            } else if (right == to) {
                left--;
                height = Math.min(height, hist[left]);
            } else if (hist[left - 1] > hist[right + 1]) {
                left--;
                height = Math.min(height, hist[left]);
            } else {
                right++;
                height = Math.min(height, hist[right]);
            }
            width++;
            sum = Math.max(sum, width * height);
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            size = Integer.parseInt(st.nextToken());
            visited = new long[size];
            if (size == 0) {
                break;
            }

            hist = new int[size];
            for (int i = 0; i < size; i++) {
                hist[i] = Integer.parseInt(st.nextToken());
            }

            long sum = divideConquer(0, size-1);

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}

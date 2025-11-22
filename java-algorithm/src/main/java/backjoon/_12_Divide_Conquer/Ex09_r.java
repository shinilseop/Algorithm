package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex09_r {
    static int size;
    static long[] hist;

    public static void stackAnswer() {
        long max = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < hist.length; i++) {
            while (!stack.isEmpty() && hist[stack.peek()] > hist[i]) {
                long height = hist[stack.pop()];
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            long height = hist[stack.pop()];
            long width = stack.isEmpty() ? hist.length : hist.length - stack.peek() - 1;
            max = Math.max(max, height * width);
        }

        System.out.println(max);
    }

    public static long divideConquer(int start, int end) {
        if (start == end) {
            return hist[start];
        }

        int mid = (start+end)/2;
        long sum = Math.max(divideConquer(start, mid), divideConquer(mid + 1, end));
        int lo = mid, hi = mid+1;
        long width = 2, height = Math.min(hist[lo], hist[hi]);
        sum = Math.max(sum, width * height);
        while (start < lo || hi < end) {
            if (lo == start) {
                hi++;
                height = Math.min(height, hist[hi]);
            } else if (hi == end) {
                lo--;
                height = Math.min(height, hist[lo]);
            } else if (hist[lo - 1] > hist[hi + 1]) {
                lo--;
                height = Math.min(height, hist[lo]);
            } else {
                hi++;
                height = Math.min(height, hist[hi]);
            }

            width++;
            sum = Math.max(sum, height * width);
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            size = Integer.parseInt(st.nextToken());
            if (size == 0) break;
            hist = new long[size];
            for (int i = 0; i < size; i++) hist[i] = Long.parseLong(st.nextToken());

//            stackAnswer();
            System.out.println(divideConquer(0, size-1));
        }
    }
}

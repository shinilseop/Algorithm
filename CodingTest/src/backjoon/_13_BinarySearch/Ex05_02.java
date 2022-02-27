package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex05_02 {
    static int[] pos;
    static int n, c;

    public static int binarySearch() {
        int lo = 1, hi = pos[n - 1] - pos[0] + 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            int installed = installRouter(mid);
            if (installed < c) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo-1;
    }

    public static int installRouter(int dist) {
        int cnt = 1;
        int lastPos = pos[0];
        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - lastPos >= dist) {
                lastPos = pos[i];
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(pos);

        System.out.println(binarySearch());
    }
}

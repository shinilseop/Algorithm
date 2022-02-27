package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex05 {
    static int[] pos;
    static int n, c;

    // 짝수개랑 홀수개랑 서로 찾는 방식이 좀 다름.

    /**
     * 짝수개는 3분할 ?
     * 홀수개는 2분할 ?
     */
    public static int installRouter(int lo, int hi, int router) {
        System.out.println();
        System.out.println(lo + " ~~ " + hi + " START r : " + router);
        if (router <= 0) {
            System.out.println("ROTUER 0 !");
            return Integer.MAX_VALUE;
        }

        if (hi - lo < router) {
            System.out.println("길이 부족 !");
            return Integer.MAX_VALUE;
        }

        int maxDist = 0;
        int mid = (lo + hi) / 2;
        boolean keep = true;
        System.out.println("loop : " + lo + " " + mid + " " + hi);
        while (keep) {
            keep = false;
            int dist = Math.min(pos[mid] - pos[lo], pos[hi] - pos[mid]);
            System.out.println("INDEXS => lo : " + lo + ",\tmid : " + mid + ",\thi : " + hi);
            System.out.println("VALUES => lo : " + pos[lo] + ",\tmid : " + pos[mid] + ",\thi : " + pos[hi]);
            System.out.println("MAXDist : " + maxDist + ", dist : " + dist);

            maxDist = Math.max(maxDist, dist);
            if (pos[mid] - pos[lo] <= pos[hi] - pos[mid]) {
                dist = Math.min(pos[mid + 1] - pos[lo], pos[hi] - pos[mid + 1]);
//                System.out.println("INDEXS => lo : " + lo + ",\tmid : " + (mid + 1) + ",\thi : " + hi);
//                System.out.println("VALUES => lo : " + pos[lo] + ",\tmid : " + pos[(mid + 1)] + ",\thi : " + pos[hi]);
//                System.out.println("DIST : " + (pos[mid + 1] - pos[lo]) + ", " + (pos[hi] - pos[mid + 1]));
                System.out.println("KEEP ? MAXDist : " + maxDist + ", dist : " + dist);
                if (maxDist < dist) {
                    System.out.println("KEEP ? router : " + (router - 1) / 2 + " < mid~hi : " + (hi - (mid+1)));
                    if ((router - 1) / 2 < (hi - (mid+1))) {
                        mid++;
                        keep = true;
                    }
                }
            } else {
                dist = Math.min(pos[mid - 1] - pos[lo], pos[hi] - pos[mid - 1]);
//                System.out.println("INDEXS => lo : " + lo + ",\tmid : " + (mid + 1) + ",\thi : " + hi);
//                System.out.println("VALUES => lo : " + pos[lo] + ",\tmid : " + pos[(mid + 1)] + ",\thi : " + pos[hi]);
                System.out.println("KEEP ? MAXDist : " + maxDist + ", dist : " + dist);
                if (maxDist < dist) {
                    System.out.println("KEEP ? router : " + (router - 1) / 2 + " < lo~mid : " + ((mid-1) - lo));
                    if ((router - 1) / 2 < ((mid-1) - lo)) {
                        mid--;
                        keep = true;
                    }
                }
            }

            if (!keep) {
                router--;
                maxDist = Math.min(maxDist, divideConquer(lo, hi, mid, router));
            }
        }

        return maxDist;
    }

    public static int divideConquer(int lo, int hi, int mid, int router) {
        if (router == 0)
            return Integer.MAX_VALUE;

        int maxDist = Integer.MAX_VALUE;
        if (router % 2 == 0) {
            if (router >= 4) {
                int lo_mid = (lo + mid) % 2 == 0 ? (lo + mid) / 2 : (lo + mid) / 2 + 1;
                int hi_mid = (hi + mid) % 2 == 0 ? (hi + mid) / 2 : (hi + mid) / 2 + 1;
                maxDist = Math.min(maxDist, installRouter(lo, lo_mid+1, router / 4));
                maxDist = Math.min(maxDist, installRouter(lo_mid, mid, router / 4));
                maxDist = Math.min(maxDist, installRouter(mid, hi_mid+1, router / 4));
                maxDist = Math.min(maxDist, installRouter(hi_mid
                        , hi, router / 4));
            } else {
                maxDist = Math.min(maxDist, installRouter(lo, mid, router / 2));
                maxDist = Math.min(maxDist, installRouter(mid, hi, router / 2));
            }
        } else {
            if (mid - lo > hi - mid) {
                maxDist = Math.min(maxDist, installRouter(lo, mid, router / 2 + 1));
                maxDist = Math.min(maxDist, installRouter(mid, hi, router / 2));
            } else {
                maxDist = Math.min(maxDist, installRouter(lo, mid, router / 2));
                maxDist = Math.min(maxDist, installRouter(mid, hi, router / 2 + 1));
            }
        }

        return maxDist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pos = new int[n];
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(pos);
//        max = pos[n-1];
//        min = pos[0];

        if (c > 2) {
            System.out.println(installRouter(0, n - 1, c - 2));
        } else {
            System.out.println(pos[n - 1] - pos[0]);
        }
    }
}

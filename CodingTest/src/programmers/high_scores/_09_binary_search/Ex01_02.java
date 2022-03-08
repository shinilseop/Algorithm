package programmers.high_scores._09_binary_search;

public class Ex01_02 {
    public long binarySearch(int[] times, long lo, long hi, int n) {
        while (lo < hi) {
            long mid = (lo+hi)/2;

            long cnt = calProcessMan(times, mid);

            if (n <= cnt) {
                hi=mid;
            } else {
                lo=mid+1;
            }
        }

        return lo;
    }

    public long calProcessMan(int[] times, long minute) {
        long cnt = 0;
        for (int i = 0; i < times.length; i++) {
            cnt+=minute/times[i];
        }
        return cnt;
    }

    public long solution(int n, int[] times) {
        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < times.length; i++) {
            min = Math.min(min, times[i]);
        }

        long answer = binarySearch(times, 1, min*n, n);

        return answer;
    }
}

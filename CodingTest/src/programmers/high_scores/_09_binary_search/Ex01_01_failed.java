package programmers.high_scores._09_binary_search;

import java.util.ArrayList;

public class Ex01_01_failed {
    public int findMinTime(int[] need) {
        int minIdx = -1, value = Integer.MAX_VALUE;
        for (int i = 0; i < need.length; i++) {
            if (value > need[i]) {
                minIdx = i;
                value = need[i];
            }
        }

        return minIdx;
    }

    public int findMinTime_considerUse(int[] times, int[] need) {
        int minIdx = -1, value = Integer.MAX_VALUE;
        for (int i = 0; i < need.length; i++) {
            if (value > (need[i] + times[i])) {
                minIdx = i;
                value = need[i];
            }
        }

        return minIdx;
    }

    public ArrayList<Integer> usingTime(int[] need, int spend) {
        ArrayList<Integer> zeroIdx = new ArrayList<>();
        for (int i = 0; i < need.length; i++) {
            need[i] -= spend;
            if(need[i]==0) zeroIdx.add(i);
        }
        return zeroIdx;
    }

    public long solution(int n, int[] times) {
        long answer = 0;

        int[] need = new int[times.length];
        for (int i = 0; i < times.length; i++) {
            need[i] = times[i];
        }
        n -= times.length;
        int timeSum = 0;
        while (n > 0) {
//            int idx = -1;
//            if (n >= times.length) {
//                System.out.println("JUST MIN");
//                idx = findMinTime(need);
//            } else {
//                System.out.println("Consider Using MIN");
//                idx = findMinTime_considerUse(times, need);
//            }
            int idx = findMinTime_considerUse(times, need);

            System.out.println("Spend : "+need[idx]);
            timeSum += need[idx];
            ArrayList<Integer> zeroIdx = usingTime(need, need[idx]);
            for (Integer zeroPos : zeroIdx) {
                if (n > 0) {
                    System.out.println("Batch : "+times[zeroPos]);
                    need[zeroPos] = times[zeroPos];
                    n--;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < need.length; i++) {
            max = Math.max(max, need[i]);
        }
        System.out.println("Last : "+max);
        timeSum += max;

        return timeSum;
    }
}

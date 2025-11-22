package programmers.high_scores._09_binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex02_02 {
    public int distance_binary(int distance, int[] rocks, int n) {
        int lo = 1, hi = distance+1;


        while (lo < hi) {
            int mid = (lo + hi) / 2;

            // 바위의 개수
            int cnt = countRock(distance, mid, rocks);

            // UpperBound [거리의 상한치]
            // 바위의 개수가 적으면 거리제한을 낮춰서 개수 증가
            if (cnt < rocks.length - n) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo-1;
    }

    public int countRock(int distance, int dist, int[] rocks) {
        /**
         * 거리를 기준으로 바위 카운팅
         * 1. 이분탐색의 기준이 되는 거리는 바위 사이의 거리 시작점-바위1, 바위1-바위2 의 간격을 정하는 기준이다.
         * 2. 마지막 바위의 경우 예외인데 마지막의 전전바위-전바위, 전바위-마지막바위, 마지막바위-거리의 끝 이기 때문에
         *    거리의 끝이 존재해서 예외처리를 해주어서 계산해야 한다.
         */
        int len = rocks.length;
        ArrayList<Integer> rockIdx = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (rockIdx.size() > 0) {
                if (rocks[i] - rocks[rockIdx.get(rockIdx.size() - 1)] >= dist) {
                    rockIdx.add(i);
                }
            } else {
                if (rocks[i] - 0 >= dist) {
                    rockIdx.add(i);
                }
            }
        }


        // 거리의 끝 부터 dist가 가능한지 검증
        for (int i = rockIdx.size() - 1; i >= 0; i--) {
            if (distance - rocks[rockIdx.get(i)] >= dist) {
                break;
            } else {
                rockIdx.remove(i);
            }
        }

        return rockIdx.size();
    }

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        return distance_binary(distance, rocks, n);
    }

    public static void main(String[] args) {
        Ex02_02 test = new Ex02_02();
        System.out.println(test.solution(25, new int[]{2, 14, 11, 21, 17}, 2));
        System.out.println(test.solution(5, new int[]{3}, 1));
        System.out.println(test.solution(48, new int[]{12, 25, 38, 43}, 1));
        System.out.println(test.solution(9, new int[]{3,6}, 1));

    }
}

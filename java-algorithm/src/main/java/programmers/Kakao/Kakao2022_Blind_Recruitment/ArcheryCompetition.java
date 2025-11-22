package programmers.Kakao.Kakao2022_Blind_Recruitment;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArcheryCompetition {
    public static void main(String[] args) {
//        int n = 9;
//        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
//
//        System.out.println("result:"+Arrays.toString(solution(n, info)));
//        int n = 10;
//        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
//
//        System.out.println("result:"+Arrays.toString(solution(n, info)));
        int n = 1;
        int[] info = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println("result:"+Arrays.toString(solution(n, info)));
    }

    static int maxScore;
    static int lowScore, lowCount;
    static int[] maxLion;
    static int[] apeech;

    public static int[] solution(int n, int[] info) {
        int[] answer = {};

        maxScore = 0;
        lowScore = Integer.MAX_VALUE;
        lowCount = 0;
        apeech=info;

        maxLion = new int[apeech.length];
        int[] lion = new int[apeech.length];
        dfs(lion, 0, n);

        if (lowScore == Integer.MAX_VALUE) {
            maxLion = new int[]{-1};
        }

        return maxLion;
    }

    public static void change(int[] lion, int score, int low, int count) {
//        System.out.println(Arrays.toString(lion)+" score:"+score+", low:"+low+", count:"+count);
        maxScore = score;
        lowScore = low;
        lowCount = count;
        for (int i = 0; i < maxLion.length; i++) {
            maxLion[i] = lion[i];
        }
    }

    public static void dfs(int[] lion, int depth, int r) {
//        System.out.println(Arrays.toString(lion) +" >> "+r);
        if (depth == lion.length || r == 0) {
            // scoring
            int apSum = 0;
            int liSum = 0;
            int liLowScore = Integer.MAX_VALUE;
            int liLowCount = 0;
            for (int i = 0; i < lion.length; i++) {
                if (apeech[i] < lion[i]) {
                    liSum+=10-i;
                    liLowScore = 10-i;
                    liLowCount = lion[i];
                } else if (apeech[i] > lion[i]) {
                    apSum+=10-i;
                }
            }
            int sub = liSum - apSum;


//            System.out.println("answer ?"+Arrays.toString(lion)+" score:"+sub+", low:"+liLowScore+", count:"+liLowCount);
            if (sub > maxScore) {
                change(lion, sub, liLowScore, liLowCount);
            } else if (sub != 0 && sub == maxScore) {
                if (liLowScore < lowScore) {
                    change(lion, sub, liLowScore, liLowCount);
                } else if (liLowScore == lowScore) {
                    if (liLowCount > lowScore) {
                        change(lion, sub, liLowScore, liLowCount);
                    }
                }
            }

            return;
        }

        if (depth == lion.length - 1) {
            // 마지막이면 전부
            lion[depth] = r;
            dfs(lion, depth + 1, r - lion[depth]);
            lion[depth] = 0;
        } else {
            // 아예 안쏘고 지나가기
            dfs(lion, depth + 1, r);

            // apeech보다 화살개수 하나 앞서가기
            if (apeech[depth] + 1 <= r) {
                lion[depth] = apeech[depth] + 1;
                dfs(lion, depth + 1, r - lion[depth]);
                lion[depth] = 0;
            }
        }
    }
}

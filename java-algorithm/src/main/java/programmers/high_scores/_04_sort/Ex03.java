package programmers.high_scores._04_sort;

import java.util.Arrays;

public class Ex03 {
    public static int binarySearch(int[] citations, int lo, int hi) {
        while (lo < hi) {
            int h = (lo + hi) / 2;

            int cntHi = 0;
            for (int i = 0; i < citations.length; i++) {
                if(citations[i] >= h){
                    cntHi++;
                }
            }

            if (cntHi < h) {
                hi = h;
            } else {
                lo = h+1;
            }
        }

        return lo-1;
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = binarySearch(citations, 0, Math.max(citations.length, citations[citations.length - 1]));

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int[] citations2 = {1, 2, 2, 3, 3, 3, 6, 6, 7, 7, 8, 8};
        int[] citations3 = {2,3,6,5,4,3,2,1,11,14,20,15,17,12,13,21};
        int[] citations4 = {1, 2, 2, 3, 3, 3, 6, 6, 7, 7, 7, 8, 8, 9, 9};
        int[] citations5 = {0, 0, 2, 1, 1, 0, 2};
        int[] citations6 = {0, 0, 0, 0, 0};
        int[] citations7 = {10, 10, 10, 10, 10};

        System.out.println(solution(citations));
        System.out.println(solution(citations2));
        System.out.println(solution(citations3));
        System.out.println(solution(citations4));
        System.out.println(solution(citations5));
        System.out.println(solution(citations6));
        System.out.println(solution(citations7));
    }
}

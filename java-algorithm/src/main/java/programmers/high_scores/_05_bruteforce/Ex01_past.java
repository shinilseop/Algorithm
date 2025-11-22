package programmers.high_scores._05_bruteforce;

public class Ex01_past {
    public class Solution {
        public int[] solution(int[] answer) {
            int[][] person = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
            int correct[] = new int[3];

            for (int i = 0; i < person.length; i++) {
                int idx = 0;
                for (int j = 0; j < answer.length; j++) {
                    if (idx == person[i].length) {
                        idx = 0;
                    }
                    if (person[i][idx++] == answer[j]) {
                        correct[i]++;
                    }
                }
            }

            int max=Math.max(correct[0], Math.max(correct[1], correct[2]));

            int size = 0;
            for (int i = 0; i < correct.length; i++) {
                if (max == correct[i])
                    size++;
            }
            int rank[] = new int[size];
            int idx=0;
            for (int i = 0; i < correct.length; i++) {
                if (max == correct[i])
                    rank[idx++]=i+1;
            }

            return rank;
        }
    }
}

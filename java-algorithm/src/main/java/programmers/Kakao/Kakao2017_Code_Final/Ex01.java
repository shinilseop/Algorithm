package programmers.Kakao.Kakao2017_Code_Final;

import java.util.Arrays;

public class Ex01 {
    static class Solution {
        static char[] character = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        static char[] batch;
        static boolean visited[];
        static String[] conditions;
        static int answer = 0;

        public boolean isPossible(String condition) {
            char oper = condition.charAt(3);
            int num = condition.charAt(4) - '0';
            int front = -1, back = -1;
            for (int j = 0; j < batch.length; j++) {
                if (condition.charAt(0) == batch[j]) {
                    front = j;
                } else if (condition.charAt(2) == batch[j]) {
                    back = j;
                }
            }

            int cnt = Math.abs(front - back)-1;
            System.out.println(Arrays.toString(batch)+":::"+condition);
            System.out.println(condition.charAt(0)+"("+front+") ~ "+condition.charAt(2)+"("+back+")");
            switch (oper) {
                case '=':
                    if (cnt == num) return true;
                    break;
                case '>':
                    if (cnt > num) return true;
                    break;
                case '<':
                    if (cnt < num) return true;
                    break;
            }

            return false;
        }

        public boolean isPossible() {
            for (int i = 0; i < conditions.length; i++) {
                if (!isPossible(conditions[i])) {
                    return false;
                }
            }

            return true;
        }

        public void dfs(int idx) {
            if (idx == batch.length) {
                if (isPossible()) {
                    answer++;
                    System.out.println("ADD");
                }
                return;
            }

            for (int i = 0; i < batch.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    batch[idx] = character[i];
                    dfs(idx + 1);
                    visited[i] = false;
                }
            }
        }

        public int solution(int n, String[] data) {
            answer=0;
            conditions = data;
            visited = new boolean[character.length];
            batch = new char[character.length];
            dfs(0);

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2, new String[]{"N~F=0", "R~T>2"}));
//        System.out.println(s.solution(2, new String[]{"M~C<2", "A~C<5"}));
    }
}

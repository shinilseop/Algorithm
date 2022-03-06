package programmers.high_scores._06_greedy;

public class Ex02 {
    static int answer, cnt;
    static boolean[] visited;

    public static void dfs(char[] names, int start, int move, int change) {
        if (change == cnt) {
            answer = Math.min(answer, move);
            return;
        }

        int left = start - 1, leftCnt = 1;
        if (left == -1) {
            left = names.length - 1;
        }
        while (left != start) {
            if (!visited[left]) {
                visited[left] = true;
                int moveAdd = leftCnt + Math.min(1 + 'Z' - names[left], names[left] - 'A');
                dfs(names, left, move + moveAdd, change + 1);
                visited[left] = false;
            }
            left--;
            leftCnt++;
            if (left == -1) {
                left = names.length - 1;
            }
        }

        int right = start + 1, rightCnt = 1;
        if (right == names.length) {
            right = 0;
        }
        while (right != start) {
            if (!visited[right]) {
                visited[right] = true;
                int moveAdd = rightCnt + Math.min(1 + 'Z' - names[right], names[right] - 'A');
                dfs(names, right, move + moveAdd, change + 1);
                visited[right] = false;
            }
            right++;
            rightCnt++;
            if (right == names.length) {
                right = 0;
            }
        }
    }

    public static int solution(String name) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[name.length()];
        char[] names = name.toCharArray();
        cnt = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == 'A') {
                visited[i] = true;
            } else {
                cnt++;
            }
        }

        int move = 0, change = 0;
        if (names[0] != 'A') {
            move = Math.min(1 + 'Z' - names[0], names[0] - 'A');
            names[0] = 'A';
            change++;
            visited[0] = true;
        }
        dfs(names, 0, move, change);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("JAN"));
        System.out.println(solution("JOAOAOAAAAAAAOAA"));
    }
}

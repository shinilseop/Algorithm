package programmers.high_scores._05_bruteforce;

import java.util.HashSet;

public class Ex02 {
    static boolean[] visited;
    static boolean isNormal[];
    static HashSet<String> distinct;

    public int dfs(String number, String make) {
        int cnt = 0;

        for (int i = 0; i < number.length(); i++) {
            if (!visited[i] && (make.length()!=0 || number.charAt(i) != '0')) {
                visited[i] = true;
                cnt+=dfs(number, make + number.charAt(i));
                if (!isNormal[Integer.parseInt(make + number.charAt(i))] && !distinct.contains(make + number.charAt(i))) {
                    cnt++;
                    distinct.add(make + number.charAt(i));
                    System.out.println(make + number.charAt(i));
                }
                visited[i] = false;
            }
        }
        return cnt;
    }

    public int solution(String numbers) {
        int answer = 0;

        distinct = new HashSet<>();
        visited = new boolean[numbers.length()];
        isNormal = new boolean[10000000];
        isNormal[0] = true;
        isNormal[1] = true;
        for (int i = 2; i < isNormal.length; i++) {
            if (!isNormal[i]) {
                for (int j = i + i; j < isNormal.length; j += i) {
                    isNormal[j] = true;
                }
            }
        }

        answer = dfs(numbers, "");

        return answer;
    }
}

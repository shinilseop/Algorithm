package programmers.Kakao.Kakao2020_Internship;

import java.io.IOException;
import java.util.ArrayList;

public class Ex03 {
    static boolean[] visited;
    static char[] oper = {'+', '-', '*'};
    static ArrayList<Long> nums;
    static ArrayList<Character> opers;

    public long solve(char[] sequence) {
        ArrayList<Character> op = new ArrayList<>();
        op.addAll(opers);
        ArrayList<Long> n = new ArrayList<>();
        n.addAll(nums);

        for (int i = 0; i < sequence.length; i++) {
            for (int j = 0; j < op.size(); j++) {
                if (sequence[i] == op.get(j)) {
                    long result = 0;
                    switch (sequence[i]) {
                        case '+':
                            result = n.get(j)+n.get(j+1);
                            break;
                        case '-':
                            result = n.get(j)-n.get(j+1);
                            break;
                        case '*':
                            result = n.get(j)*n.get(j+1);
                            break;
                    }
                    n.set(j, result);
                    n.remove(j+1);
                    op.remove(j);

                    j--;
                }
            }
        }

        return n.get(0);
    }

    public long dfs(char[] sequence, int idx) {
        if (idx == 3) {
            return solve(sequence);
        }

        long max =  0;

        for (int i = 0; i < oper.length; i++) {
            if (!visited[i]) {
                visited[i]=true;
                sequence[idx] = oper[i];
                max = Math.max(max, Math.abs(dfs(sequence, idx+1)));
                visited[i]=false;
            }
        }

        return max;
    }

    public long solution(String expression) {
        long answer = 0;

        nums = new ArrayList<>();
        opers = new ArrayList<>();
        String[] n = expression.split("\\+|-|\\*");
        char[] o = expression.replaceAll("[0-9]", "").toCharArray();
        for (int i = 0; i < n.length; i++) {
            nums.add(Long.parseLong(n[i]));
        }
        for (int i = 0; i < o.length; i++) {
            opers.add(o[i]);
        }

        char[] sequence = new char[3];
        visited = new boolean[3];
        answer = Math.abs(dfs(sequence, 0));

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex03 main = new Ex03();

        main.solution("100-200*300-500+20");
//        main.solution("50*6-3*2");
//        main.solution("1-30*1-29");
//        main.solution("-1");
//        main.solution("-1-1");
//        main.solution("177-661*999*99-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99");
//        main.solution("200-300-500-600*40+500+500");
//        main.solution("2-990-5+2");
//        main.solution("-2+2");
////        main.solution("-6+2*2");
//        main.solution("-4-8");
//        main.solution("5-5*2-5+8");
//        main.solution("");
    }
}

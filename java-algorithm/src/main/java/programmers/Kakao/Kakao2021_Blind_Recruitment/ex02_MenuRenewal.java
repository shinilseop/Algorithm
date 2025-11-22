package programmers.Kakao.Kakao2021_Blind_Recruitment;

import java.util.*;

public class ex02_MenuRenewal {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        orders = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        course = new int[]{2, 3, 5};
        orders = new String[]{"XYZ", "XWY", "WXA"};
        course = new int[]{2, 3, 4};

        System.out.println(Arrays.toString(solution.solution(orders, course)));
    }

    static class Solution {

        Map<String, Integer> cnt;
        boolean[] visited;
        int maxCnt;

        public String[] solution(String[] orders, int[] course) {
            List<String> ans = new ArrayList<>();


            for (int i = 0; i < course.length; i++) {
                cnt = new HashMap<>();
                maxCnt = 0;

                for (int j = 0; j < orders.length; j++) {
                    visited = new boolean[orders[j].length()];

                    char[] chars = orders[j].toCharArray();
                    Arrays.sort(chars);
                    String ordered = new String(chars);

                    System.out.println("START :" + orders[j] + " max:" + Math.min(orders[j].length(), course[i]));
                    dfs(ordered, "", 0, 0, Math.min(orders[j].length(), course[i]));
                }

                System.out.println("=====result=====");
                for (String key : cnt.keySet()) {
                    System.out.println(key + " : " + cnt.get(key));
                }
                System.out.println("=====finish=====");

                if (maxCnt >= 2) {
                    for (String key : cnt.keySet()) {
                        if (cnt.get(key) == maxCnt) {
                            ans.add(key);
                        }
                    }
                }
            }

            String[] answer = ans.stream().sorted().distinct().map(String::new).toArray(String[]::new);
            return answer;
        }

        private void dfs(String order, String menu, int start, int depth, int maxDepth) {
            System.out.println(menu);
            if (depth == maxDepth) {
                cnt.put(menu, cnt.getOrDefault(menu, 0) + 1);
                maxCnt = Math.max(maxCnt, cnt.get(menu));
                return;
            }

            for (int i = start; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(order, menu + String.valueOf(order.charAt(i)), i + 1, depth + 1, maxDepth);
                    visited[i] = false;
                }
            }
        }
    }
}

package programmers.Kakao.Kakao2021_Blind_Recruitment;

import java.util.*;

public class ex04_RankSearch2_addBinarySearch {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println(Arrays.toString(solution.solution(info, query)));

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedMemory + " bytes");
    }

    static class Solution {
        Map<String, List<Integer>> map;

        public int[] solution(String[] info, String[] query) {
            map = new HashMap<>();

            for (String i : info) {
                String[] split = i.split(" ");
                dfs(split, 0, "");
            }

            for (String key : map.keySet()) {
                List<Integer> scores = map.get(key);
                Collections.sort(scores);
            }

            List<Integer> list = new ArrayList<>();
            for (String q : query) {
                String[] temp = q.replaceAll(" and ", "").split(" ");
                String key = temp[0];
                String scr = temp[1];

                List<Integer> scores = map.getOrDefault(key, new ArrayList<>());
                if (scr.equals("-")) {
                    list.add(scores.size());
                } else {
                    list.add(binarySearch(scores, Integer.parseInt(scr)));
                }
            }

            int[] answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }

        private int binarySearch(List<Integer> scores, int std) {
            int left = 0, right = scores.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (scores.get(mid) < std) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return scores.size() - left;
        }

        public void dfs(String[] info, int depth, String query) {
            if (depth == info.length - 1) {
                List<Integer> scores = map.getOrDefault(query, new ArrayList<>());
                scores.add(Integer.parseInt(info[depth]));
                map.put(query, scores);
                return;
            }

            dfs(info, depth + 1, query + "-");
            dfs(info, depth + 1, query + info[depth]);
        }
    }
}

package programmers.Kakao.Kakao2021_Blind_Recruitment;

import java.util.*;

public class ex04_RankSearch {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println(Arrays.toString(solution.solution(info, query)));

    }

    static class Solution {
        Map<String, Person> map;

        String[][] defaults = {{"cpp", "java", "python"},
                {"backend", "frontend"},
                {"junior", "senior"},
                {"chicken", "pizza"}};
        int cnt;

        public int[] solution(String[] info, String[] query) {
            map = new HashMap<>();

            for (String i : info) {
                StringTokenizer st = new StringTokenizer(i, " ");
                String merge = st.nextToken() + st.nextToken() + st.nextToken() + st.nextToken();
                int score = Integer.parseInt(st.nextToken());

                Person p = map.getOrDefault(merge, new Person());
                p.scores.add(score);
                map.put(merge, p);
            }

            List<Integer> list = new ArrayList<>();
            for (String q : query) {
                String[] split = q.split(" and ");
                StringTokenizer st = new StringTokenizer(split[3], " ");
                String[] cruit = {split[0], split[1], split[2], st.nextToken(), st.nextToken()};
                cnt = 0;

                dfs(cruit, 0, "");

                list.add(cnt);
            }

            int[] answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
//            int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
            return answer;
        }

        public void dfs(String[] query, int depth, String result) {
            if (depth == query.length - 1) {
                if (map.containsKey(result)) {
                    Person persons = map.get(result);
                    if (query[depth].equals("-")) {
                        cnt += persons.scores.size();
                    } else {
                        int std = Integer.parseInt(query[depth]);
                        for (Integer score : persons.scores) {
                            if (score >= std) {
                                cnt++;
                            }
                        }
                    }
                }
                return;
            }

            if (!query[depth].equals("-")) {
                dfs(query, depth + 1, result + query[depth]);
                return;
            }

            for (int i = 0; i < defaults[depth].length; i++) {
                dfs(query, depth + 1, result + defaults[depth][i]);
            }
        }

        class Person {
            List<Integer> scores;

            public Person() {
                this.scores = new ArrayList<>();
            }
        }
    }
}

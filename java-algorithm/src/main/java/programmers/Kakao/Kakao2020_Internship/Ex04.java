package programmers.Kakao.Kakao2020_Internship;

import java.util.*;

public class Ex04 {
    public int[] solution(String[] gems) {
        HashSet<String> items = new HashSet<>();
        for (String gem : gems) items.add(gem);

        HashMap<String, Integer> set = new HashMap<>();
        int minIdx = 0, maxIdx = 1000000000;

        int start = 0, end = 0;
        for (int i = 0; i < gems.length; i++) {
            set.put(gems[i], set.getOrDefault(gems[i], 0) + 1);
            end++;

            if (items.size() == set.size()) {
                System.out.println("start:"+i+":"+start+" "+end);
                while (set.get(gems[start]) > 1) {
                    set.put(gems[start], set.get(gems[start]) - 1);
                    start++;
                    System.out.println("move "+start+" "+end);
                }

                if (end - start < maxIdx - minIdx) {
                    minIdx = start;
                    maxIdx = end;
                }
            }
        }

        int[] answer = {minIdx + 1, maxIdx};

        return answer;
    }

    public static void main(String[] args) {
        Ex04 main = new Ex04();
        System.out.println(Arrays.toString(main.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }
}

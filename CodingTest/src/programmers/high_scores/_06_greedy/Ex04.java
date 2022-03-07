package programmers.high_scores._06_greedy;

import java.util.Arrays;
import java.util.Collections;

public class Ex04 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // Stream 때문에 속도가 안나옴.
//        Integer[] peoples = Arrays.stream(people).boxed().toArray(Integer[]::new);
//        Arrays.sort(peoples, Collections.reverseOrder());
//        int lastMan = peoples.length;
//        for (int i = 0; i < lastMan; i++) {
//            int sum = peoples[i];
//            for (int j = lastMan-1; j > i; j--) {
//                if (sum + peoples[j] <= limit) {
//                    sum+=people[j];
//                    lastMan=j;
//                } else {
//                    break;
//                }
//            }
//
//            answer++;
//        }

        Arrays.sort(people);
        int lastMan = -1;
        for (int i = people.length-1; i > lastMan; i--) {
            int sum = people[i];
            if (sum + people[lastMan+1] <= limit) {
                sum+=people[++lastMan];
            }

            answer++;
        }

        return answer;
    }
}

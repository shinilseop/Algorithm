package programmers.high_scores._01_hash;

import java.io.*;
import java.util.*;

public class Ex01 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> completionMap = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            if (completionMap.containsKey(completion[i])) {
                completionMap.put(completion[i], completionMap.get(completion[i])+1);
            } else {
                completionMap.put(completion[i], 1);
            }
        }

        for (int i = 0; i < participant.length; i++) {
            if (completionMap.containsKey(participant[i])) {
                if (completionMap.get(participant[i]) == 1) {
                    completionMap.remove(participant[i]);
                } else {
                    completionMap.put(participant[i], completionMap.get(participant[i])-1);
                }
            } else {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};

//        System.out.println(solution(participant2, completion2));
        System.out.println(solution(participant3, completion3));
    }
}

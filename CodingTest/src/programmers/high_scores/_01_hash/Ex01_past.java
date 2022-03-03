package programmers.high_scores._01_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//public class Solution {
public class Ex01_past {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0;i<completion.length;i++) {
            String srch=completion[i];
            if(hm.containsKey(srch)) {
                hm.replace(srch, hm.get(srch)+1);
            } else {
                hm.put(srch, 1);
            }
        }

        for(int i=0;i<participant.length;i++) {
            String srch=participant[i];
            if(hm.containsKey(srch)) {
                if(hm.get(srch)==1) {
                    hm.remove(srch);
                } else {
                    hm.replace(srch, hm.get(srch)-1);
                }
            } else {
                answer=srch;
                break;
            }
        }

        return answer;
    }
}
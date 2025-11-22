package programmers.SkillUp_Test.Level2_1;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex01 {
    public static void main(String[] args) {
        String msg = "KAKAO";
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<String, Integer> dict = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            char ch = (char) ('A' + i - 1);
            dict.put(String.valueOf(ch), i);
        }

        int idx = 27;
        for (int i = 0; i < msg.length();) {
            int findIdx = 0;
            for (int j = msg.length();j>i; j--) {
                if (dict.containsKey(msg.substring(i, j))) {
                    findIdx = j;
                    break;
                }
            }

            ans.add(dict.get(msg.substring(i, findIdx)));
            dict.put(msg.substring(i, Math.min(findIdx+1, msg.length())), idx++);

            i += msg.substring(i, findIdx).length();
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
    }
}

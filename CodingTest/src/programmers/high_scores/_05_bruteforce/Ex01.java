package programmers.high_scores._05_bruteforce;

import java.util.ArrayList;

public class Ex01 {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        int idx1=0, idx2=0, idx3=0;
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == p1[idx1++]) cnt1++;
            if(answers[i] == p2[idx2++]) cnt2++;
            if(answers[i] == p3[idx3++]) cnt3++;

            idx1 = idx1 == p1.length?0:idx1;
            idx2 = idx2 == p2.length?0:idx2;
            idx3 = idx3 == p3.length?0:idx3;
        }

        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        ArrayList<Integer> ans = new ArrayList<>();
        if(max == cnt1) ans.add(1);
        if(max == cnt2) ans.add(2);
        if(max == cnt3) ans.add(3);

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}

package programmers.high_scores._06_greedy;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {
    public static String solution(String number, int k) {
        int idx = 0, changed = k;
        ArrayList<Character> list = new ArrayList<>();
        for (char ch : number.toCharArray()) {
            list.add(ch);
        }

        while (list.size() != number.length() - k) {



            if (idx == list.size() - 1) {
                break;
            } else if (list.get(idx) < list.get(idx + 1)) {
                list.remove(idx);
                changed--;
                idx = idx == 0 ? 0 : idx - 1;
                if (changed == 0) {
                    break;
                }
            } else {
                idx++;
            }
        }

        StringBuffer answer = new StringBuffer(list.size() - changed + 1);
        for (int i = 0; i < list.size() - changed; i++) {
            answer.append(list.get(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
}

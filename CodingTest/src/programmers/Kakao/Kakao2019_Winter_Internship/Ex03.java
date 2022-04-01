package programmers.Kakao.Kakao2019_Winter_Internship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Ex03 {
    String[] user_id, banned_id;
    boolean[] used;
    static int answer = 0;
    ArrayList<HashSet<String>> answerList;

    public boolean isSame(String user, String banned) {
        for (int j = 0; j < banned.length(); j++) {
            if (banned.charAt(j) != '*' && banned.charAt(j) != user.charAt(j)) {
                break;
            }

            if (j == banned.length()-1) {
                return true;
            }
        }

        return false;
    }

    public void dfs(HashSet<String> set, int idx) {
        if (idx == banned_id.length) {
            if (answerList.size() == 0) {
                answerList.add(set);
                return;
            }

            boolean find = false;
            for (int i = 0; i < answerList.size(); i++) {
                Iterator<String> iter = set.iterator();
                while (iter.hasNext()) {
                    String value = iter.next();
                    if (!answerList.get(i).contains(value)) {
                        break;
                    }

                    if (answerList.get(i).contains(value) && !iter.hasNext()) {
                        find = true;
                    }
                }

                if (find) {
                    break;
                }
            }

            if (!find) {
                answerList.add(set);
            }

            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!used[i] && user_id[i].length() == banned_id[idx].length()) {
                if (isSame(user_id[i], banned_id[idx])) {
                    used[i] = true;
                    HashSet<String> tmpSet = new HashSet<>();
                    tmpSet.addAll(set);
                    tmpSet.add(user_id[i]);
                    dfs(tmpSet, idx+1);
                    used[i] = false;
                }
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        used = new boolean[user_id.length];
        answerList = new ArrayList<>();
        dfs(new HashSet<>(), 0);
        return answerList.size();
    }

    public static void main(String[] args) {
        Ex03 main = new Ex03();
//        System.out.println(main.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
//        System.out.println(main.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(main.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
}

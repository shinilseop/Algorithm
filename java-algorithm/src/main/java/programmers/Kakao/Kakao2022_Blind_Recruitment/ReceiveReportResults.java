package programmers.Kakao.Kakao2022_Blind_Recruitment;

import java.util.*;

public class ReceiveReportResults {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reported = new HashMap<>();
        Map<String, Integer> mailed = new HashMap<>();

        for (String user : id_list) {
            reported.put(user, new HashSet<>());
            mailed.put(user, 0);
        }

        for (int i = 0; i < report.length; i++) {
            String split[] = report[i].split(" ");
            String u = split[0];
            String r = split[1];

            Set<String> reporter = reported.get(r);
            reporter.add(u);
        }

        for (String user : id_list) {
            Set<String> reporter = reported.get(user);

            if (reporter.size() >= k) {
                for (String send : reporter) {
                    mailed.put(send, mailed.get(send) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailed.get(id_list[i]);
        }

        return answer;
    }
}
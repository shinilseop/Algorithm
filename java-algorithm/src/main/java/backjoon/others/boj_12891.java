package backjoon.others;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String password = br.readLine();

        st = new StringTokenizer(br.readLine(), " ");
        Map<Character, Integer> minMap = new HashMap<>();
        minMap.put('A', Integer.parseInt(st.nextToken()));
        minMap.put('C', Integer.parseInt(st.nextToken()));
        minMap.put('G', Integer.parseInt(st.nextToken()));
        minMap.put('T', Integer.parseInt(st.nextToken()));

        Map<Character, Integer> cntMap = new HashMap<>();
        cntMap.put('A', 0);
        cntMap.put('C', 0);
        cntMap.put('G', 0);
        cntMap.put('T', 0);

        for (int i = 0; i < P; i++) {
            char ch = password.charAt(i);
            cntMap.put(ch, cntMap.get(ch)+1);
        }

        int ans=0;
        if (isAnswer(minMap, cntMap)) {
            ans++;
        }

        for (int i = 1; i < S - P + 1; i++) {
            cntMap.put(password.charAt(i - 1), cntMap.get(password.charAt(i - 1)) - 1);
            cntMap.put(password.charAt(i - 1 + P), cntMap.get(password.charAt(i - 1 + P)) + 1);
            if (isAnswer(minMap, cntMap)) {
                ans++;
            }
        }

//        char[] check = {'A', 'C', 'G', 'T'};
//        int ans = 0;
//        for (int i = 0; i < S - P + 1; i++) {
//            boolean isSuccess = true;
//            for (int j = 0; j < 4; j++) {
//                if (!counting(password.substring(i, i + P).toCharArray(), check[j], minCnt[j])) {
//                    isSuccess = false;
//                    break;
//                }
//            }
//
//            if (isSuccess) {
//                ans++;
//            }
//        }

        System.out.println(ans);
    }

    public static boolean counting(char[] target, char key, int targetCnt) {
        int cnt = 0;
        for (int i = 0; i < target.length; i++) {
            if (key == target[i]) {
                cnt++;
            }

            if (cnt >= targetCnt) {
                return true;
            }
        }

        return false;
    }

    public static boolean isAnswer(Map<Character, Integer> minMap, Map<Character, Integer> cntMap) {
        char[] check = {'A', 'C', 'G', 'T'};
        for (int i = 0; i < check.length; i++) {
            if (minMap.get(check[i]) > cntMap.get(check[i])) {
                return false;
            }
        }

        return true;
    }
}

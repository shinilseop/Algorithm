package programmers.high_scores._05_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex02_past {
    public class Solution {
        public int solution(String numbers) {
            int answer = 0;
            char[] num = numbers.toCharArray();
            boolean primeNum[] = new boolean[10000000];

            primeNum[0] = primeNum[1] = true;
            for (int i = 2; i < primeNum.length; i++) {
                if (!primeNum[i]) {
                    for (int j = i + i; j < primeNum.length; j += i) {
                        if (!primeNum[j]) {
                            primeNum[j] = true;
                        }
                    }
                }
            }

            Map<Integer, Integer> arr = new HashMap<>();
            for (int i = 1; i <= numbers.length(); i++) {
                boolean visited[] = new boolean[num.length];
                dfs(arr, num, "", i, visited);
            }

            Iterator<Integer> iter=arr.keySet().iterator();
            while(iter.hasNext()) {
                int n=iter.next();
                if(!primeNum[n])
                    answer++;
            }


            return answer;
        }

        public void dfs(Map<Integer, Integer> arr, char[] num, String number, int len, boolean[] visited) {
            if (number.length() == len) {
                arr.put(Integer.parseInt(number), 0);
                return;
            }

            for (int i = 0; i < num.length; i++) {
                if (!visited[i]) {
                    if (num[i] == '0') {
                        if (number.length() == 0) {
                            continue;
                        }
                    }
                    visited[i] = true;
                    dfs(arr, num, number + String.valueOf(num[i]), len, visited);
                    visited[i]=false;
                }
            }
        }
    }
}

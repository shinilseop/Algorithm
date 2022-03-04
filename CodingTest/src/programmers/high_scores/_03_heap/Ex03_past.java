package programmers.high_scores._03_heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Ex03_past {

    public class Solution {
        public int[] solution(String[] operations) {
            int ans[] = new int[2];

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < operations.length; i++) {
                StringTokenizer st = new StringTokenizer(operations[i]);
                String ord = st.nextToken();
                int ordnum = Integer.parseInt(st.nextToken());
                if (ord.equals("I")) {
                    list.add(ordnum);
                } else if (ord.equals("D") && list.size() > 0) {
                    if (ordnum == 1) {
                        Collections.sort(list);
                        list.remove(list.size() - 1);
                    } else if (ordnum == -1) {
                        Collections.sort(list);
                        list.remove(0);
                    }
                }
            }

            Collections.sort(list);
            if (list.size() == 1) {
                ans[0]=ans[1]=list.get(0);
            } else if (list.size() > 1) {
                ans[0]=list.get(list.size()-1);
                ans[1]=list.get(0);
            }

            return ans;
        }
    }
}

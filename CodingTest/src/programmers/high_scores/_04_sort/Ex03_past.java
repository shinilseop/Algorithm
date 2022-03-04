package programmers.high_scores._04_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex03_past {
    public class Solution {
        public int solution(int[] citations) {
            int h=0;

            Arrays.sort(citations);
            int len=citations[citations.length-1];
            int idx=0;
            for(int i=1;i<len;i++) {
                while(idx<citations.length) {
                    if(i<=citations[idx]) {
                        if(i<=citations.length-idx) {
                            h=i;
                            break;
                        }
                    }
                    idx++;
                }
            }

            return h;
        }
    }
}

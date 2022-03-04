package programmers.high_scores._04_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex02_past {
    public class Solution {
        public String solution(int[] numbers) {
            StringBuffer ans = new StringBuffer();

            String[] str = new String[numbers.length];
            Queue<Word> q = new PriorityQueue<>();
            for(int i=0;i<str.length;i++) {
                q.offer(new Word(String.valueOf(numbers[i])));
            }

            while(!q.isEmpty()) {
                Word w=q.poll();
                ans.append(w.word);
            }

            if(ans.charAt(0)=='0')
                return "0";

            return ans.substring(0, ans.length());
        }
    }

    class Word implements Comparable<Word>{
        String word;

        Word(String word){
            this.word=word;
        }

        public int compareTo(Word w) {
            int snum=Integer.parseInt(this.word+w.word);
            int cnum=Integer.parseInt(w.word+this.word);
            return cnum-snum;
        }
    }
}

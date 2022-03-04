package programmers.high_scores._02_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Ex04_past {
    public class Solution {
        public int[] solution(int[] prices) {
            PriorityQueue<Stock> stock = new PriorityQueue<>();
            int answer[] = new int[prices.length];

            for (int i = 0; i < prices.length; i++) {
                while (!stock.isEmpty() && stock.peek().price > prices[i]) {
                    Stock s = stock.poll();
                    answer[s.entrytime]=i-s.entrytime;
                }
                stock.add(new Stock(prices[i], i));
            }

            while (!stock.isEmpty()) {
                Stock s = stock.poll();
                answer[s.entrytime]=answer.length-s.entrytime-1;
            }

            return answer;
        }
    }

    class Stock implements Comparable<Stock> {
        int price;
        int entrytime;

        Stock(int price, int entrytime) {
            this.price = price;
            this.entrytime = entrytime;
        }

        public int compareTo(Stock s) {
            if (this.price < s.price) {
                return 1;
            } else if (this.price > s.price) {
                return -1;
            }
            return 0;
        }
    }
}

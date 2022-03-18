package programmers.SkillUp2.Level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public long solution(int price, int money, int count) {
        long sigma = (count*(count+1))/2;
        return Math.max(price*sigma-money, 0);
    }

    public long solution2(int price, int money, int count) {
        for (int i = 1; i <= count; i++) {
            money-=(price*i);
        }
        return Math.max(-money, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
    }
}

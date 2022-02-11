package backjoon._04_bruteforece;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ex01 {
    static boolean visited[];
    static int num[];
    static int blackjack;
    static int minSum = 0;

    public static void findBlackJack(int loop, int sum){
        if(loop==3){
            minSum = Math.max(minSum, sum);
        } else {
            for (int i = 0; i < num.length; i++) {
                if (!visited[i]) {
                    if (sum + num[i] <= blackjack) {
//                        System.out.println(i + " 방문 " + sum + "+" + num[i] + "=" + (sum + num[i]) + ", min=" + minSum);
                        visited[i] = true;
                        findBlackJack(loop + 1, sum + num[i]);
                        visited[i] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        blackjack = m;

        st = new StringTokenizer(br.readLine());
        num = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        findBlackJack(0, 0);

        System.out.println(minSum);
    }
}

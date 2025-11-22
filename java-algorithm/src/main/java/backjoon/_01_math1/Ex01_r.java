package backjoon._01_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int fixCost = Integer.parseInt(st.nextToken());
        int valCost = Integer.parseInt(st.nextToken());
        int valProfit = Integer.parseInt(st.nextToken());

        if (valCost >= valProfit) {
            System.out.println(-1);
        } else {
            int profit = valProfit - valCost;
            System.out.println(((fixCost/profit)+1));
        }
    }
}

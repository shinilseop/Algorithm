package backjoon._01_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int fixCost = Integer.parseInt(st.nextToken());
        int varCost = Integer.parseInt(st.nextToken());
        int sellCost = Integer.parseInt(st.nextToken());
        int profit = sellCost - varCost;

        if (profit <= 0)
            System.out.println(-1);
        else
            System.out.println((fixCost/profit+1));
    }
}

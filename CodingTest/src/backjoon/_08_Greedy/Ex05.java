package backjoon._08_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] dist = new int[size-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size-1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        int[] cost = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long minCost = cost[0];
        long distSum = dist[0];
        long costSum = 0;
        for(int i=1;i<size-1;i++){
            if(minCost > cost[i]) {
                costSum += distSum * minCost;
                distSum = dist[i];
                minCost = cost[i];
            } else {
                distSum += dist[i];
            }
        }
        costSum += distSum * minCost;

        System.out.println(costSum);
    }
}

package backjoon._11_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if(num==1){
            System.out.println(1);
        } else {
            Queue<Integer> q = new LinkedList<>();
            for (int i = 2; i <= num; i += 2) {
                q.offer(i);
            }

            boolean isInsert = num%2==0?false:true;
            while (q.size() > 1) {
                if (isInsert) {
                    q.offer(q.poll());
                } else {
                    q.poll();
                }
                isInsert = !isInsert;
                if (q.size() == 1) {
                    break;
                }
            }

            System.out.println(q.poll());
        }
    }
}

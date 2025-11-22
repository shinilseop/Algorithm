package backjoon.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        //System.out.println(queue);

        while (queue.size() > 1) {
            queue.poll();//첫번째값 삭제
            queue.add(queue.poll());//버리는값 다시 추가
            // 1 2 3 4 5 6 7 -> 6
            // 1 2 3 4 5 6 -> 4
            // 1 2 3 4 5 -> 2
            // 1 2 3 4 -> 4
            // 1 2 3 -> 2
            // 1 2 -> 2
            // 1 -> 1
        }
        System.out.println(queue.peek());//첫번째값 반환



      /*for(int i = N; i> 1; i--) {
         if(queue.size() == 1 ) {
            System.out.println(queue.peek());
         }else {
            queue.remove();//첫번째값 삭제
            int a = queue.peek();//첫번째값 반환
            queue.add(a);//추가
         }
      }*/
    }
}

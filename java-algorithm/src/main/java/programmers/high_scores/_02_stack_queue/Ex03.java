package programmers.high_scores._02_stack_queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex03 {

    public static class Truck {
        int weight, pos;

        Truck(int weight, int pos) {
            this.weight = weight;
            this.pos = pos;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> q = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            q.offer(new Truck(truck_weights[i], 1));
        }

        int sum = 0, time = 0;
        while (!q.isEmpty() || !bridge.isEmpty()) {
            if (!bridge.isEmpty()) {
                int len = bridge.size();
                for (int i = 0; i < len; i++) {
                    Truck tmp = bridge.poll();
                    tmp.pos++;

//                    System.out.println(tmp.weight+"->"+tmp.pos+" "+bridge.size()+" "+i);
                    if (tmp.pos > bridge_length) {
                        sum -= tmp.weight;
                        continue;
                    } else {
                        bridge.offer(tmp);
                    }
                }
            }


            if (!q.isEmpty()) {
                Truck t = q.peek();
                if (t.weight + sum <= weight) {
//                    System.out.println(t.weight+" "+t.pos+" in");
                    sum += t.weight;
                    bridge.offer(t);
                    q.poll();
                }
            }

            time++;
//            System.out.println("time : "+time);
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(5, 10, new int[]{2, 3, 4, 10}));
//        System.out.println(solution(5, 10, new int[]{2, 3, 4, 10}));
//        System.out.println(solution(5, 10, new int[]{2, 3, 4, 10}));
    }
}

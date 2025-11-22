package Test_Result.Software_Maestro_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex01 {

    public static class Food implements Comparable<Food> {
        ArrayList<Integer> people;
        int p;
        int idx;

        public Food(int p, int idx) {
            people=new ArrayList<>();
            this.p=p;
            this.idx=idx;
        }

        @Override
        public int compareTo(Food food) {
            return this.p - food.p;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        Food[] food = new Food[M]; // idx, p
        for (int i = 0; i < M; i++) {
            food[i] = new Food(0, i);
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int p = Integer.parseInt(st.nextToken());
                if (p >= 5) {
                    food[j].people.add(i);
                    food[j].p++;
                }
            }
        }

        Arrays.sort(food);
//        for (int i = 0; i < food.length; i++) {
//            System.out.println(food[i].idx+">>>"+food[i].p);
//            for (Integer person : food[i].people) {
//                System.out.print(person+" ");
//            }
//            System.out.println();
//        }

        int cnt=0;
        boolean[] remain = new boolean[N];
        for (int i = K; i < M; i++) {
            for (Integer person : food[i].people) {
                if (!remain[person]) {
                    remain[person] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}


//5 5 2
//7 1 7 1 1
//7 7 7 7 1
//7 7 7 7 7
//7 7 1 7 7
//1 7 1 1 7
package Test_Result.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ex05 {
    public class Round implements Comparable<Round> {
        int firstState, secondState;
        int gap;

        public Round(int firstState, int secondState) {
            this.firstState = firstState;
            this.secondState = secondState;
            gap = firstState - secondState;
        }


        @Override
        public int compareTo(Round o) {
//            if (this.gap == o.gap) {
//                return this.secondState - o.secondState;
//            }
            return -(this.gap - o.gap);
        }
    }

    public long solution(int[] abilities, int k) {
        long answer = 0;

        Arrays.sort(abilities);
        Round[] round = new Round[(abilities.length + 1) / 2];
        int idx = 0;
        for (int i = abilities.length - 1; i >= 0; i -= 2) {
            if (i == 0) {
                round[idx] = new Round(abilities[i], 0);
            } else {
                round[idx++] = new Round(abilities[i], abilities[i - 1]);
            }
        }
        Arrays.sort(round);

        for (int i = 0; i < round.length; i++) {
            System.out.println(i+"round ::: "+round[i].firstState+" "+round[i].secondState+" "+round[i].gap);
        }

        for (int i = 0; i < k; i++) {
            answer += round[i].firstState;
            System.out.println("use  select "+round[i].firstState);
        }
        for (int i = k; i < round.length; i++) {
            answer += round[i].secondState;
            System.out.println("just select "+round[i].secondState);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex05 main = new Ex05();


        int[] abilities = {10,8,8,6};
        int k = 2;
//        System.out.println(main.solutions());
//        System.out.println(Arrays.toString(main.solutions()));
    }
}

package backjoon._03_loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int end = 3;
        int tmp = 2;
        int start = 1;

        num--;
        ArrayList<Move> before = new ArrayList<>();
        before.add(new Move(1, 3));
        ArrayList<Move> after = before;

        while (num-- > 0) {
            after = new ArrayList<>();
            /**
             * Step 1. 전 단계 움직임에서 end 3->2, tmp 2->3 로 변경해서 추가
             * Step 2. 제일 큰 막대 옮기기 add(new Move(1,3));
             * Step 3. 전 단계 움직임에서 end 1->2, tmp 2->1 로 변경해서 추가
             */

            // Step 1
            for (int i = 0; i < before.size(); i++) {
                after.add(before.get(i).step1());
            }

            // Step 2
            after.add(new Move(1, 3));

            // Step 3
            for (int i = 0; i < before.size(); i++) {
                after.add(before.get(i).step3());
            }

            before = after;
        }


        StringBuffer sb = new StringBuffer(after.size() * 3);
        sb.append(after.size()).append("\n");
        for (int i = 0; i < after.size(); i++) {
            Move m = after.get(i);
            sb.append(m.start).append(" ").append(m.end).append("\n");
//            System.out.println(m.start+" "+m.end);
        }
        System.out.print(sb.toString());
    }

    static class Move {
        int start;
        int end;

        public Move(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Move step1() {
            int startTmp = 0;
            int endTmp = 0;

            switch (start) {
                case 1:
                    startTmp = 1;
                    break;
                case 2:
                    startTmp = 3;
                    break;
                case 3:
                    startTmp = 2;
                    break;
            }

            switch (end) {
                case 1:
                    endTmp = 1;
                    break;
                case 2:
                    endTmp = 3;
                    break;
                case 3:
                    endTmp = 2;
                    break;
            }

            return new Move(startTmp, endTmp);
        }

        public Move step3() {
            int startTmp = 0;
            int endTmp = 0;

            switch (start) {
                case 1:
                    startTmp = 2;
                    break;
                case 2:
                    startTmp = 1;
                    break;
                case 3:
                    startTmp = 3;
                    break;
            }

            switch (end) {
                case 1:
                    endTmp = 2;
                    break;
                case 2:
                    endTmp = 1;
                    break;
                case 3:
                    endTmp = 3;
                    break;
            }

            return new Move(startTmp, endTmp);
        }
    }
}

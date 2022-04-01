package programmers.Kakao.Kakao2020_Internship;

import java.util.PriorityQueue;

public class Ex01 {
    static char[][] keys = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}, {'*', '0', '#'}};
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public class Hand implements Comparable<Hand> {
        int y, x;
        int move;

        public Hand(int y, int x, int move) {
            this.y = y;
            this.x = x;
            this.move = move;
        }

        @Override
        public int compareTo(Hand hand) {
            return this.move - hand.move;
        }
    }

    public Hand bfs(Hand hand, char key) {
        PriorityQueue<Hand> q = new PriorityQueue<>();
        q.add(new Hand(hand.y, hand.x, 0));

        while (!q.isEmpty()) {
            Hand now = q.poll();

            if (keys[now.y][now.x] == key) {
                return now;
            }

            for (int i = 0; i < 4; i++) {
                int tmpY = now.y + dy[i];
                int tmpX = now.x + dx[i];

                if (0 <= tmpY && tmpY < keys.length) {
                    if (0 <= tmpX && tmpX < keys[0].length) {
                        q.offer(new Hand(tmpY, tmpX, now.move + 1));
                    }
                }
            }
        }

        return hand;
    }

    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();

        Hand left = new Hand(3, 0, 0);
        Hand right = new Hand(3, 2, 0);
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
//            1,2,3
//            4,5,6
//            7,8,9
            if (n == 1 || n == 4 || n == 7) {
                answer.append('L');
                left.y = (n - 1) / 3;
                left.x = (n - 1) % 3;
            } else if (n == 3 || n == 6 || n == 9) {
                answer.append('R');
                right.y = (n - 1) / 3;
                right.x = (n - 1) % 3;
            } else {
                Hand tmpL = bfs(left, (char) (n + '0'));
                Hand tmpR = bfs(right, (char) (n + '0'));

//                System.out.println("LEFT START : " + left.y + " " + left.x);
//                System.out.println("RIGHT START : " + right.y + " " + right.x);
//                System.out.println(i + ":" + tmpL.move + " " + tmpR.move);

                if (tmpL.move < tmpR.move) {
                    left = tmpL;
                    answer.append('L');
                } else if (tmpL.move == tmpR.move) {
                    if (hand.equals("right")) {
                        answer.append('R');
                        right = tmpR;
                    } else {
                        left = tmpL;
                        answer.append('L');
                    }
                } else {
                    right = tmpR;
                    answer.append('R');
                }
            }
        }

        return answer.toString();
    }
}

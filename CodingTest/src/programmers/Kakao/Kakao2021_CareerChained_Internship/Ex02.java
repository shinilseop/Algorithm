package programmers.Kakao.Kakao2021_CareerChained_Internship;

import java.util.Arrays;

public class Ex02 {
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};// 거리1짜리
    static int[] dx2 = {-2, -1, 0, 1, 2, 1, 0, -1}, dy2 = {0, -1, -2, -1, 0, 1, 2, 1}; // 거리2짜리

    public boolean isDisted(String[] batch) {
        for (int i = 0; i < batch.length; i++) {
            System.out.println(batch[i]);
        }

        for (int i = 0; i < batch.length; i++) {
            for (int j = 0; j < batch[i].length(); j++) {
                if (batch[i].charAt(j) == 'P') {
                    // 거리 1
                    for (int d = 0; d < dx.length; d++) {
                        int tmpY = dy[d]+i;
                        int tmpX = dx[d]+j;

                        if (0 <= tmpY && tmpY < batch.length) {
                            if (0 <= tmpX && tmpX < batch[0].length()) {
                                if (batch[tmpY].charAt(tmpX) == 'P') {
                                    System.out.println("dist1 : "+i+" "+j+" "+tmpY+" "+tmpX);
                                    return false;
                                }
                            }
                        }
                    }

                    // 거리 2
                    for (int d = 0; d < dx2.length; d++) {
                        int tmpY = dy2[d]+i;
                        int tmpX = dx2[d]+j;

                        if (0 <= tmpY && tmpY < batch.length) {
                            if (0 <= tmpX && tmpX < batch[0].length()) {
                                if (batch[tmpY].charAt(tmpX) == 'P') {
                                    if (!isAllPartitions(batch, i, j, tmpY, tmpX)) {
                                        System.out.println("dist2 : "+i+" "+j+" "+tmpY+" "+tmpX);
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isAllPartitions(String[] batch, int y, int x, int tmpY, int tmpX) {
        int minX = Math.min(x, tmpX);
        int maxX = Math.max(x, tmpX);
        int minY = Math.min(y, tmpY);
        int maxY = Math.max(y, tmpY);

        for (int i = minY; i < maxY+1; i++) {
            for (int j = minX; j < maxX+1; j++) {
                if (i == y && j == x) {
                    continue;
                }
                if (i == tmpY && j == tmpX) {
                    continue;
                }
                if (batch[i].charAt(j) != 'X') {
                    return false;
                }
            }
        }

        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            if (isDisted(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex02 main = new Ex02();
//        System.out.println(Arrays.toString(main.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}})));
        System.out.println(Arrays.toString(main.solution(new String[][]{{"PXOP","XPXO","PXPX"}})));
    }
}

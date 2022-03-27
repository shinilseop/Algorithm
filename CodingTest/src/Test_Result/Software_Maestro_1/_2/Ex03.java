package Test_Result.Software_Maestro_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex03 {
    static int[][][] block = {{{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {0, -1}, {1, 0}, {1, 1}},
            {{0, 0}, {0, -1}, {1, 0}, {0, 1}},
            {{0, 0}, {-2, 0}, {-1, 0}, {0, 1}}};
    static int[] rotateN = {1, 0, 1, 3, 7};
    static long max = 0;
    static int[][] maxIdx = new int[4][2];
    static boolean[][] visited;

    public static int[][] rotate(int[][] block) {
        int[][] tmp = Arrays.copyOf(block, block.length);

        for (int i = 0; i < tmp.length; i++) {
            int temp = -tmp[i][0];
            tmp[i][0] = tmp[i][1];
            tmp[i][1] = temp;
        }

        return tmp;
    }

    public static void blockMax(int[][] board, int[][] block) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int sum = 1;
                int[][] idxes = new int[4][2];
                for (int d = 0; d < block.length; d++) {
                    int y=i+block[d][0];
                    int x=j+block[d][1];
//                    System.out.println("CHECK "+y+" "+x);
                    idxes[d][0] = y;
                    idxes[d][1] = x;
                    if (0 <= y && y < board.length) {
                        if (0 <= x && x < board[i].length) {
                            if (!visited[y][x]) {
                                sum *= board[y][x];
                                continue;
                            }
                        }
                    }
                    sum = 0;
                    break;
                }

                if (max < sum) {
                    max = sum;
                    maxIdx=idxes;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int width = Integer.parseInt(br.readLine());

        int[][] board = new int[4][width];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long sum = 0;
        visited=new boolean[4][width];
        while (true) {
            max = 0;
            for (int b = 0; b < block.length; b++) {
                blockMax(board, block[b]);
                for (int r = 0; r < rotateN.length; r++) {
                    int[][] blockRotate = rotate(block[b]);
                    blockMax(board, blockRotate);
                }
            }

            if (max == 0) {
                break;
            } else {
                System.out.println("========="+max+"=========");
                sum+=max;
                for (int i = 0; i < maxIdx.length; i++) {
                    int y=maxIdx[i][0];
                    int x=maxIdx[i][1];
                    System.out.println("remove "+y+" "+x);
                    visited[y][x]=true;
                }
            }
        }

        System.out.println(sum);
    }
}

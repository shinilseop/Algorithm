package Test_Result.dev_first_half_2022;

import java.util.ArrayList;

public class Ex02_2 {
    static char[][] board;
    static boolean[][] visited, search;
    static char[] chs = {'a', 'b', 'c'};
    static int[] alphaCnt;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    ArrayList<Integer> answerList;

    public void divideConquer(int y, int x) {
        for (char ch : chs) {
            board[y][x] = ch;
            System.out.println(y+" "+x+" "+ch);
            if (isPossible()) {
                System.out.println("Possible");
                boolean isSearch = false;
                for (int dir = 0; dir < 4; dir++) {
                    int tmpY = y+dy[dir];
                    int tmpX = x+dx[dir];

                    if (0 <= tmpY && tmpY < board.length) {
                        if (0 <= tmpX && tmpX < board[0].length) {
                            if (board[tmpY][tmpX] == '?') {
                                isSearch=true;
                                divideConquer(tmpY, tmpX);
                            }
                        }
                    }
                }

                if (!isSearch) {
                    answerList.set(answerList.size() - 1, answerList.get(answerList.size() - 1) + 1);
                }
            }
            board[y][x] = '?';
        }
    }

    public boolean isPossible() {
        for (char ch : chs) {
            int cnt = 0;
            int startY=0, startX=0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == ch) {
                        if (startY == -1) {
                            startY=i;
                            startX=j;
                        }
                        cnt++;
                    }
                }
            }

            search = new boolean[board.length][board[0].length];
            search[startY][startX]=true;
            System.out.println("count "+cntChar(startY, startX, ch)+" "+cnt);
            if (cntChar(startY, startX, ch) != cnt) {
                return false;
            }
        }

        return true;
    }

    public int cntChar(int y, int x, char ch) {
        int cnt = 0;

        for (int dir = 0; dir < 4; dir++) {
            int tmpY = y+dy[dir];
            int tmpX = x+dx[dir];

            if (0 <= tmpY && tmpY < board.length) {
                if (0 <= tmpX && tmpX < board[0].length) {
                    if (!search[tmpY][tmpX]) {
                        search[tmpY][tmpX]=true;
                        if (board[tmpY][tmpX] == '?') {
                            cnt+=cntChar(tmpY, tmpX, ch);
                        } else if (board[tmpY][tmpX] == ch) {
                            cnt++;
                            cnt+=cntChar(tmpY, tmpX, ch);
                        }
                    }
                }
            }
        }

        return cnt;
    }

    public int solution(String[] grid) {
        board = new char[grid.length][grid[0].length()];
        visited = new boolean[grid.length][grid[0].length()];
        alphaCnt = new int[3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                board[i][j] = grid[i].charAt(j);
                if (board[i][j] != '?') alphaCnt[board[i][j] - 'a']++;
            }
        }


        answerList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '?') {
                    for (int dir = 0; dir < 4; dir++) {
                        int tmpY = i+dy[dir];
                        int tmpX = j+dx[dir];

                        if (0 <= tmpY && tmpY < board.length) {
                            if (0 <= tmpX && tmpX < board[0].length) {
                                if (!visited[tmpY][tmpX] && board[tmpY][tmpX] == '?') {
                                    visited[tmpY][tmpX]=true;
                                    answerList.add(0);
                                    divideConquer(tmpY, tmpX);
                                }
                            }
                        }
                    }
                }
            }
        }

        int answer = 1;
        for (int i = 0; i < answerList.size(); i++) {
            answer*=answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex02_2 main = new Ex02_2();

        String[] grid = {"??b", "abc", "cc?"};
        System.out.println("EX 01 START");
        System.out.println(main.solution(grid));

        String[] grid2 = {"abcabcab","????????"};
        System.out.println("\n\n\n\n\nEX 02 START");
        System.out.println(main.solution(grid2));

        String[] grid3 = {"aa?"};
        System.out.println("\n\n\n\n\nEX 03 START");
        System.out.println(main.solution(grid3));
    }
}

//    grid	result
//["??b", "abc", "cc?"]	2
//        ["abcabcab","????????"]	0
//        ["aa?"]	3
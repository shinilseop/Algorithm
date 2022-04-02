package Test_Result.dev_first_half_2022;

import java.util.ArrayList;

public class Ex02 {
    static boolean visited[][], searchVisit[][];
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static char[] ch = {'a', 'b', 'c'};
    static int[] alphaCnt = new int[3];
    static ArrayList<Integer> cnts;

    public void divideConquer(int y, int x) {
        for (int i = 0; i < ch.length; i++) {
            board[y][x] = ch[i];
            alphaCnt[ch[i]-'a']++;
            searchVisit = new boolean[board.length][board[0].length];
            searchVisit[y][x] = true;
            int countAlphabet = dfsCnt(y, x, ch[i]);
            System.out.println(y+" "+x+" "+ch[i]+" cmp:"+countAlphabet+" "+alphaCnt[ch[i]-'a']);
            if (countAlphabet == alphaCnt[ch[i] - 'a']) {
                boolean searched = false;
                for (int dir = 0; dir < 4; dir++) {
                    int tmpY = y + dy[dir];
                    int tmpX = x + dx[dir];

                    if (0 <= tmpY && tmpY < board.length) {
                        if (0 <= tmpX && tmpX < board[0].length) {
                            if (board[tmpY][tmpX] == '?') {
                                searched=true;
                                visited[tmpY][tmpX] = true;
                                divideConquer(tmpY, tmpX);
                            }
                        }
                    }
                }
                if (!searched) {
                    cnts.set(cnts.size() - 1, cnts.get(cnts.size() - 1) + 1);
                }
            }
            board[y][x] = '?';
            alphaCnt[ch[i]-'a']--;
        }
    }

    public int dfsCnt(int y, int x, char key) {
        int cnt=1;
        for (int dir = 0; dir < 4; dir++) {
            int tmpY = y + dy[dir];
            int tmpX = x + dx[dir];

            if (0 <= tmpY && tmpY < board.length) {
                if (0 <= tmpX && tmpX < board[0].length) {
                    if (!searchVisit[tmpY][tmpX]) {
                        if (board[tmpY][tmpX] == key) {
                            searchVisit[tmpY][tmpX]=true;
                            cnt++;
                        } else if (board[tmpY][tmpX] == '?') {
                            searchVisit[tmpY][tmpX]=true;
                            cnt+=dfsCnt(tmpY, tmpX, key);
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
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                board[i][j] = grid[i].charAt(j);
                if (board[i][j] != '?') alphaCnt[board[i][j]-'a']++;
            }
        }

        cnts = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '?') {
                    for (int dir = 0; dir < 4; dir++) {
                        int tmpY = i + dy[dir];
                        int tmpX = j + dx[dir];

                        if (0 <= tmpY && tmpY < board.length) {
                            if (0 <= tmpX && tmpX < board[0].length) {
                                if (board[tmpY][tmpX] == '?' && !visited[tmpY][tmpX]) {
                                    cnts.add(0);
                                    visited[tmpY][tmpX]=true;
                                    divideConquer(tmpY, tmpX);
                                }
                            }
                        }
                    }
                }
            }
        }

        int answer = 1;
        for (int i = 0; i < cnts.size(); i++) {
            if (cnts.get(i) != 0) {
                answer *= cnts.get(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] grid = {"??b", "abc", "cc?"};
        Ex02 main = new Ex02();
        System.out.println(main.solution(grid));
    }
}

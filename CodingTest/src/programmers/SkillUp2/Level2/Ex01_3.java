package programmers.SkillUp2.Level2;

public class Ex01_3 {
    public int solution(int[][] board) {
        int sum = 0;

        int[][] prefixWidth = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1)
                    sum = 1;
                if (board[i][j] != 0) {
                    prefixWidth[i][j] = j > 0 ? prefixWidth[i][j - 1] + board[i][j] : board[i][j];
                }
            }
        }


        int[][] prefixHeight = new int[board.length][board[0].length];
        for (int i = 0; i < board[i].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0) {
                    prefixHeight[j][i] = j > 0 ? prefixHeight[j - 1][i] + board[j][i] : board[j][i];
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (prefixWidth[i][j] > 1) {
                    int height = prefixHeight[i][j];
                    int max = Math.max(board.length, i + height);
                    for (int k = i+1; k < max; k++) {

                    }
                }
            }
        }


        return sum;
    }
}

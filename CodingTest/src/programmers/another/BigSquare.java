package programmers.another;

/**
 * 가장 큰 정사각형 찾기
 */
public class BigSquare {
    public int solution(int [][]board)
    {
        int max = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 1) {
                max = 1;
                break;
            }
        }

        if (max != 1) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[0][i] == 1) {
                    max = 1;
                    break;
                }
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]))+1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }

        return max*max;
    }
}

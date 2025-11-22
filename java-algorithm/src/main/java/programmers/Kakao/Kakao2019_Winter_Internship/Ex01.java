package programmers.Kakao.Kakao2019_Winter_Internship;

import java.util.Arrays;
import java.util.Stack;

public class Ex01 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int[] idx=new int[board[0].length];
        Arrays.fill(idx, board.length);
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0) {
                    idx[i]=j;
                    break;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int moveIdx = moves[i]-1;
            if (idx[moveIdx] < board.length) {
                if (!stack.isEmpty() && stack.peek() == board[idx[moveIdx]][moveIdx]) {
                    answer+=2;
                    stack.pop();
                    idx[moveIdx]++;
                } else {
                    stack.add(board[idx[moveIdx]][moveIdx]);
                    idx[moveIdx]++;
                }
            }
        }

        return answer;
    }
}

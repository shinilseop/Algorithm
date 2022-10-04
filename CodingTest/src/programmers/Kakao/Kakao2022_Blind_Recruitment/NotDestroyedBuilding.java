package programmers.Kakao.Kakao2022_Blind_Recruitment;

public class NotDestroyedBuilding {
    public static void main(String[] args) {

    }

    public int solution(int[][] board, int[][] skills) {


        for (int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];


        }



        return -1;
    }

    public int solution2(int[][] board, int[][] skills) {
        int[][] prefix = new int[board.length+1][board[0].length + 1];
        for (int[] skill : skills) {
            boolean isAttack = skill[0] == 1;
            int degree = isAttack ? -skill[5] : skill[5];

            prefix[skill[1]][skill[2]] += degree;
            prefix[skill[1]][skill[4]+1] += -degree;
            prefix[skill[3]+1][skill[2]] += -degree;
            prefix[skill[3]+1][skill[4]+1] += degree;
        }


        for (int i = 1; i < prefix[0].length; i++) {
            for (int j = 0; j < prefix.length; j++) {
                prefix[j][i] += prefix[j][i-1];
            }
        }

        for (int i = 1; i < prefix.length; i++) {
            for (int j = 0; j < prefix[i].length; j++) {
                prefix[i][j] += prefix[i-1][j];
            }
        }

        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + prefix[i][j] > 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

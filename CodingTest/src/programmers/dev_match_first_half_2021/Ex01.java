package programmers.dev_match_first_half_2021;

public class Ex01 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int winCnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] != 0) {
                for (int j = 0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        winCnt++;
                        break;
                    }
                }
            } else {
                zeroCnt++;
            }
        }


        System.out.println(winCnt+" "+zeroCnt);
        int minWin = 6;
        if (winCnt != 0) {
            minWin = 7 - winCnt;
        }

        winCnt += zeroCnt;
        int maxWin = 6;
        if (winCnt != 0) {
            maxWin = 7 - winCnt;
        }

        int[] answer = {maxWin, minWin};
        return answer;
    }
}

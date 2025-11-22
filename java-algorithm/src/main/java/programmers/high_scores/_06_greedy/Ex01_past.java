package programmers.high_scores._06_greedy;

import java.util.Arrays;

public class Ex01_past {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i]==reserve[j]) {
                    lost[i]=-2;
                    reserve[j]=-2;
                    break;
                }
                if(lost[i]<reserve[j])
                    break;
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i]-1==reserve[j] || lost[i]+1==reserve[j]) {
                    lost[i]=-2;
                    reserve[j]=-2;
                    break;
                }
            }
        }

        for(int i=0;i<lost.length;i++) {
            if(lost[i]!=-2)
                answer--;
        }

        return answer;
    }
}

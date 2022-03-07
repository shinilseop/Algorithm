package programmers.high_scores._06_greedy;

import java.util.Arrays;

public class Ex04_past {
    public int solution(int[] people, int limit) {
        int min = 0;
        boolean escape[] = new boolean[people.length];

        Arrays.sort(people);
        int idx=0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (!escape[i]) {
                int sum = people[i];
                escape[i]=true;
                while(idx<people.length) {
                    if (!escape[idx]) {
                        if (sum + people[idx] <= limit) {
                            escape[idx]=true;
                            sum+=people[idx];
                        } else {
                            break;
                        }
                    }
                    idx++;
                }
                min++;
            }
        }

        return min;
    }
}

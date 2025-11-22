package programmers.SkillUp_Test.Level2_2;

import java.util.Arrays;

public class Ex02 {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int minIdx = 0;
        for (int i = people.length-1; i >= minIdx; i--) {
            int sum = people[i];
            for (int j = minIdx; j < i; j++) {
                if (sum + people[j] <= limit) {
                    sum+=people[j];
                    minIdx = j+1;
                } else {
                    break;
                }
            }

            answer++;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] people={70, 50, 80, 50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }
}

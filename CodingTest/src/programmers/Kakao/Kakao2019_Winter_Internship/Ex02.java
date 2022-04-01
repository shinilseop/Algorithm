package programmers.Kakao.Kakao2019_Winter_Internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Ex02 {
    public int[] solution(String s) {
        String[] sets = s.substring(1, s.length() - 1).replaceAll("\\{", "").split("}");
        for (int i = 1; i < sets.length; i++) sets[i] = sets[i].substring(1);
        Arrays.sort(sets, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(sets));
        ArrayList<String> list = new ArrayList<>();

        int idx = 0;
        HashSet<String> exists = new HashSet<>();
        for (int i = 0; i < sets.length; i++) {
            String[] nums = sets[i].split(",");
            System.out.println(Arrays.toString(nums));
            for (int j = 0; j < nums.length; j++) {
                if(!exists.contains(nums[j])){
                    list.add(nums[j]);
                    exists.add(nums[j]);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = Integer.parseInt(list.get(i));

        return answer;
    }

    public static void main(String[] args) {
        Ex02 main = new Ex02();
//        System.out.println(Arrays.toString(main.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(main.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    }
}

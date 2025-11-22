package programmers.high_scores._04_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Ex02 {
    public static String solution(int[] numbers) {
        String[] nums = IntStream.range(0, numbers.length).mapToObj(i -> String.valueOf(numbers[i])).toArray(String[]::new);
        Arrays.sort(nums, (s1, s2) -> Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2));

        StringBuffer sb = new StringBuffer();
        IntStream.range(0, nums.length).forEach(i -> {
            if (sb.length() != 0 || (!nums[i].equals("0"))) {
                sb.append(nums[i]);
            }
        });
        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
}

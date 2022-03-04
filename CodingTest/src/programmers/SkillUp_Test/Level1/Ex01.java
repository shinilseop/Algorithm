package programmers.SkillUp_Test.Level1;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class Ex01 {
    public static void main(String[] args) {
        String s = "Zbcdefg";

        String[] arr = s.split("");
        System.out.println(arr.toString());
        Arrays.sort(arr, (s1, s2) -> -s1.compareTo(s2));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}

package programmers.Kakao.Kakao2021_CareerChained_Internship;

import java.util.HashMap;

public class Ex01 {
    static HashMap<String, Integer> map;

    public int solution(String s) {
//        map.put("one", 1);
//        map.put("two", 2);
//        map.put("three", 3);
//        map.put("four", 4);
//        map.put("five", 5);
//        map.put("six", 6);
//        map.put("seven", 7);
//        map.put("eight", 8);
//        map.put("nine", 9);

        s = s.replaceAll("one", "1").replaceAll("two", "2").replaceAll("three", "3")
                .replaceAll("four", "4").replaceAll("five", "5").replaceAll("six", "6")
                .replaceAll("seven", "7").replaceAll("eight", "8").replaceAll("nine", "9").
                replaceAll("zero", "0");
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String num = "12";

        System.out.println(num.replaceAll("three", "3"));
    }
}

package programmers.SkillUp_Test.Level2_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex01 {
    public String solution(String s) {
        String answer = "";

        ArrayList<Integer> list = new ArrayList<>();
        String[] splited = s.split(" ");
        for (int i = 0; i < splited.length; i++) {
            list.add(Integer.parseInt(splited[i]));
        }

        Collections.sort(list);

        answer = list.get(0) + " " + list.get(list.size() - 1);

        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
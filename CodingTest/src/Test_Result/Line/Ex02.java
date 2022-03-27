package Test_Result.Line;

import java.util.Arrays;
import java.util.HashMap;

public class Ex02 {
    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static boolean[] canInput; // alphabet + shift
    static int n;
    static String[] sentences;
    static int answer;
    static HashMap<String, boolean[]> map;

    public class Input {
        boolean[] canInput;
        int cnt;


    }

    public void calScore() {
        int sum = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (canInput[i]) {
                System.out.print(alphabet[i]+" ");
            }
        }
        if (canInput[27]) {
            System.out.print("SHIFT");
        }
        System.out.println();

        for (int i = 0; i < sentences.length; i++) {
            int score = sentences[i].length();
            for (int j = 0; j < sentences[i].length(); j++) {
                char ch = sentences[i].charAt(j);
                if (ch != ' ') {
                    if (ch <= 'Z') {
                        score++;
//                        System.out.println("대문자  : "+ch+" "+(ch-'A'));
                        if (!canInput[27] || !canInput[ch - 'A']) {
//                            System.out.println("불");
                            break;
                        }
                    } else if (ch <= 'z') {
//                        System.out.println("소문자  : "+ch+" "+(ch-'a'));
                        if (!canInput[ch - 'a']) {
//                            System.out.println("불");
                            break;
                        }
                    }
                }

                if (j == sentences[i].length()-1) {
                    System.out.println("가능");
                    sum+=score;
                }
            }
        }

        answer = Math.max(answer, sum);
    }

    public void inputBatchDFS(int idx) {
        if (idx == n) {
            calScore();
            return;
        }

        for (int i = 0; i < canInput.length; i++) {
            if (!canInput[i]) {
                canInput[i] = true;
                inputBatchDFS(idx + 1);
                canInput[i] = false;
            }
        }
    }

    public int solution(String[] sentences, int n) {
        int answer = 0;
        this.sentences=sentences;
        this.n=n;
        canInput = new boolean[28];
        for (int i = 0; i < sentences.length; i++) {
            boolean[] need = new boolean[28];
            int cnt = 0;
            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) != ' ') {
                    if (sentences[i].charAt(j) <= 'Z') {
                        if (!need[sentences[i].charAt(j) - 'A']) {
                            need[sentences[i].charAt(j)-'A']=true;
                            cnt++;
                        }
                        if (!need[27]) {
                            need[27]=true;
                            cnt++;
                        }
                    } else if (sentences[i].charAt(j) <= 'z') {
                        if (!need[sentences[i].charAt(j) - 'a']) {
                            need[sentences[i].charAt(j)-'a']=true;
                            cnt++;
                        }
                    }
                }
            }

            if (cnt <= n) {
                map.put(sentences[i], need);
            }
        }

        inputBatchDFS(0);

        return answer;
    }

    public static void main(String[] args) {
        Ex02 main = new Ex02();
        System.out.println(main.solution(new String[]{"line in line", "LINE", "in lion"}, 5));
//        System.out.println(Arrays.toString(main.solutions()));
    }
}

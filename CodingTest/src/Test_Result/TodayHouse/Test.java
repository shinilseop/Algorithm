package Test_Result.TodayHouse;

import java.util.HashSet;

public class Test {
    public String solution(String new_id) {
        /*
        길이 3~15
        마침표 맨앞 맨뒤
        소문자, 숫자, -, _, .(예외) 가능
         */
        HashSet<Character> set = new HashSet<>();
        for (int i = 'a'; i <= 'z'; i++) set.add((char)i);
        for (int i = '0'; i <= '9'; i++) set.add((char)i);
        set.add('-');
        set.add('_');
        set.add('.');

        char[] chs = new_id.toCharArray();

        // 1단계
        for (int i = 0; i < chs.length; i++) {
            if ('A' <= chs[i] && chs[i] <= 'Z') {
                chs[i] = (char)(chs[i] + ('a' - 'A'));
            }
        }

        // 2단계
        StringBuilder word = new StringBuilder(new String(chs));
        for (int i = 0; i < word.length(); i++) {
            if (!set.contains(word.charAt(i))) {
                word.deleteCharAt(i);
                i--;
            }
        }

        // 3단계
        for (int i = 0; i < word.length()-1; i++) {
            if (word.charAt(i) == '.' && word.charAt(i + 1) == '.') {
                word.deleteCharAt(i + 1);
                i--;
            }
        }

        // 4단계
        if (word.length() > 0 && word.charAt(0) == '.') {
            word.deleteCharAt(0);
        }
        if (word.length() > 0 && word.charAt(word.length() - 1) == '.') {
            word.deleteCharAt(word.length() - 1);
        }

        // 5단계
        if (word.length() == 0) {
            word = new StringBuilder("a");
        }

        // 6단계
        if (word.length() > 15) {
            word = new StringBuilder(word.toString().substring(0, 15));
        }

        // 7단계
        if (word.length() <= 2) {
            while (word.length() != 3) {
                word.append(word.charAt(word.length() - 1));
            }
        }


        // 4단계
        if (word.length() > 0 && word.charAt(0) == '.') {
            word.deleteCharAt(0);
        }
        if (word.length() > 0 && word.charAt(word.length() - 1) == '.') {
            word.deleteCharAt(word.length() - 1);
        }


        return word.toString();
    }

    public static void main(String[] args) {
        Test main = new Test();

        System.out.println(main.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(main.solution("z-+.^."));
        System.out.println(main.solution("=.="));
        System.out.println(main.solution("123_.def"));
        System.out.println(main.solution("abcdefghijklmn.p"));
    }
}

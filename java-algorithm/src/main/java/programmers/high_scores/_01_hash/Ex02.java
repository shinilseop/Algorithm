package programmers.high_scores._01_hash;

import java.util.*;

public class Ex02 {
    public static boolean isContain(String string, String key) {
        for (int i = 0; i < key.length(); i++) {
            if (string.charAt(i) != key.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].length() > phone_book[i].length()) {
                if (isContain(phone_book[i + 1], phone_book[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input[] = {"119", "97674223", "1195524421", "00000", "28", "123", "12", "1235", "567", "88"};

        System.out.println(solution(input));
    }
}




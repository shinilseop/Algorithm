package backjoon._05_sorting;

import java.io.BufferedReader;

public class Test2 {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "bcde";
        String str3 = "aaaa";

        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str1));
        System.out.println(str1.compareTo(str3));

        int num = 7;
        char ch = (char)(num+'0');
        System.out.println(ch);
    }
}

package Test_Result.TodayHouse;

import java.util.HashMap;
import java.util.Iterator;

public class Ex02 {
    public String solution(String call) {
        String lowCall = call.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < lowCall.length(); i++) {
            for (int j = 1; j <= lowCall.length() - i; j++) {
                String key = lowCall.substring(i, i+j);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
        }

        String[] replaced = new String[call.length()+1];
        replaced[0]="";
        for(int i=1;i<replaced.length;i++) replaced[i]=replaced[i-1]+"-";
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            if (map.get(key) == max) {
                lowCall=lowCall.replaceAll(key, replaced[key.length()]);
            }
        }

        StringBuilder sb = new StringBuilder(lowCall);
        for (int i = 0; i < call.length(); i++) {
            if (sb.charAt(i) != '-') {
                if ('A' <= call.charAt(i) && call.charAt(i) <= 'Z') {
                    sb.replace(i, i + 1, String.valueOf(call.charAt(i)));
                }
            }
        }

        return sb.toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        Ex02 main = new Ex02();
        System.out.println("RESULT:"+main.solution("abcabcdefabc"));
        System.out.println("RESULT:"+main.solution("abxdeydeabz"));
        System.out.println("RESULT:"+main.solution("abcabca"));
        System.out.println("RESULT:"+main.solution("ABCabcA"));
        System.out.println("RESULT:"+main.solution("aaaaabaaaaaa"));
    }
}
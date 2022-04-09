package Test_Result.TodayHouse;

import java.util.HashMap;
import java.util.Iterator;

public class Ex03 {
    static HashMap<String, String> map;

    public boolean isVariable(String words) {
        if (words.length() > 2) {
            if (words.charAt(0) == '{' && words.charAt(words.length() - 1) == '}') {
                return true;
            }
        }

        return false;
    }

    public String solution(String tstring, String[][] variables) {
        map = new HashMap<>();
        for (String[] variable:variables) {
            map.put(variable[0], variable[1]);
        }

        String[] origin = tstring.split(" ");
        String[] changed = tstring.split(" ");
        for (int i = 0; i < changed.length; i++) {
            while (isVariable(changed[i])) {
                if (map.containsKey(changed[i].substring(1, changed[i].length() - 1))) {
                    changed[i] = map.get(changed[i].substring(1, changed[i].length() - 1));
                    if(changed[i].equals(origin[i])) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < changed.length; i++) {
            sb.append(changed[i]).append(' ');
        }

        return sb.toString().strip();
    }

    public static void main(String[] args) {
        Ex03 main = new Ex03();

        String tstring =  "this is {template} {template} is {state}";
        String[][] variable = {{"template", "string"}, {"state", "changed"}};
        System.out.println("1RESULT ::: "+main.solution(tstring, variable));

        String tstring2 =  "this is {template} {template} is {state}";
        String[][] variable2 = {{"template", "string"}, {"state", "{template}"}};
        System.out.println("\n\n2RESULT ::: "+main.solution(tstring2, variable2));

        String tstring3 =  "this is {template} {template} is {state}";
        String[][] variable3 = {{"template", "{state}"}, {"state", "{template}"}};
        System.out.println("\n\n3RESULT ::: "+main.solution(tstring3, variable3));

        String tstring4 =  "this is {template} {template} is {state}";
        String[][] variable4 = {{"template", "{state}"}, {"state", "{templates}"}};
        System.out.println("\n\n4RESULT ::: "+main.solution(tstring4, variable4));

        String tstring5 =  "{a} {b} {c} {d} {i}";
        String[][] variable5 = {{"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}};
        System.out.println("\n\n5RESULT ::: "+main.solution(tstring5, variable5));
    }
}

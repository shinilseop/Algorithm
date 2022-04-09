package Test_Result.TodayHouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex03_timeThink {
    static HashMap<String, String> map;
    static HashMap<String, Integer> mapIdx;
    static boolean[] fixed;

    public boolean isVariable(String word) {
        if (word.length() > 2) {
            if (word.charAt(0) == '{' && word.charAt(word.length() - 1) == '}') {
                return true;
            }
        }

        return false;
    }

    public String solution(String tstring, String[][] variables) {
        fixed = new boolean[variables.length];
        map = new HashMap<>();
        mapIdx = new HashMap<>();
        for (int i = 0; i < variables.length; i++) {
            String[] variable = variables[i];
            map.put(variable[0], variable[1]);
            mapIdx.put(variable[0], i);
        }

        HashMap<String, String> newMap = new HashMap<>();
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            ArrayList<String> keys = new ArrayList<>();
            String oriKey = iter.next();
            String key = oriKey;
            String value = "";
            if (newMap.containsKey(key)) {
                value = newMap.get(key);
            } else {
                value = map.get(key);
            }
            System.out.println("START");

            while (true) {
                System.out.println("key:" + key + ", value:" + value);
                keys.add(key);
                if (!isVariable(value) || !map.containsKey(value.substring(1, value.length() - 1))) {
                    System.out.println("isVariable:" + isVariable(value) + ", contains:" + map.containsKey(value));
                    for (String k : keys) {
                        if(!fixed[mapIdx.get(k)])
                            newMap.put(k, value);
                    }
                    break;
                } else if (value.substring(1, value.length() - 1).equals(oriKey)) {
                    System.out.println("CYCLE");
                    for (String k : keys) {
                        if(!fixed[mapIdx.get(k)])
                            newMap.put(k, value);
                    }
                    break;
                }

                key = value.substring(1, value.length() - 1);
                value = map.get(key);
            }

            fixed[mapIdx.get(oriKey)] = true;
        }

        System.out.println("VARIABLERS RESULT");
        Iterator<String> iters = map.keySet().iterator();
        while (iters.hasNext()) {
            String key = iters.next();
            System.out.println(key + " : " + newMap.get(key));
        }
        System.out.println("=======================");

        String[] changed = tstring.split(" ");
        for (int i = 0; i < changed.length; i++) {
            if (isVariable(changed[i]) && newMap.containsKey(changed[i].substring(1, changed[i].length() - 1))) {
                changed[i] = newMap.get(changed[i].substring(1, changed[i].length() - 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < changed.length; i++) {
            sb.append(changed[i]).append(' ');
        }

        return sb.toString().strip();
    }

    public static void main(String[] args) {
        Ex03_timeThink main = new Ex03_timeThink();

        String tstring = "this is {template} {template} is {state}";
        String[][] variable = {{"template", "string"}, {"state", "changed"}};
        System.out.println("1RESULT ::: " + main.solution(tstring, variable));
        System.out.println("\n\n");

        String tstring2 = "this is {template} {template} is {state}";
        String[][] variable2 = {{"template", "string"}, {"state", "{template}"}};
        System.out.println("2RESULT ::: " + main.solution(tstring2, variable2));
        System.out.println("\n\n");

        String tstring3 = "this is {template} {template} is {state}";
        String[][] variable3 = {{"template", "{state}"}, {"state", "{template}"}};
        System.out.println("3RESULT ::: " + main.solution(tstring3, variable3));
        System.out.println("\n\n");

        String tstring4 = "this is {template} {template} is {state}";
        String[][] variable4 = {{"template", "{state}"}, {"state", "{templates}"}};
        System.out.println("4RESULT ::: " + main.solution(tstring4, variable4));
        System.out.println("\n\n");

        String tstring5 = "{a} {b} {c} {d} {i}";
        String[][] variable5 = {{"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}};
        System.out.println("5RESULT ::: " + main.solution(tstring5, variable5));
    }
}

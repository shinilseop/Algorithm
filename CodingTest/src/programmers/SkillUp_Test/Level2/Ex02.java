package programmers.SkillUp_Test.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Ex02 {
    static HashMap<String, HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>>> infos;
    // lang, job, degree, food, score

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        infos = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" "); // 0,1,2,3,4

            HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>> jobHash = null;
            HashMap<String, HashMap<String, ArrayList<Integer>>> degreeHash = null;
            HashMap<String, ArrayList<Integer>> foodHash = null;
            ArrayList<Integer> list = null;

            infos.put(split[0], infos.getOrDefault(split[0], new HashMap<>()));
            infos.get(split[0]).put(split[1], infos.get(split[0]).getOrDefault(split[1], new HashMap<>()));
            infos.get(split[0]).get(split[1]).put(split[2], infos.get(split[0]).get(split[1]).getOrDefault(split[2], new HashMap<>()));
            infos.get(split[0]).get(split[1]).get(split[2]).put(split[3], (infos.get(split[0]).get(split[1]).get(split[2]).getOrDefault(split[3], new ArrayList<>())));
            infos.get(split[0]).get(split[1]).get(split[2]).get(split[3]).add(Integer.parseInt(split[4]));

//            if (!infos.containsKey(split[0])) {
//                jobHash = new HashMap<>();
//                degreeHash = new HashMap<>();
//                foodHash = new HashMap<>();
//                list = new ArrayList<>();
//            } else {
//                jobHash = infos.get(split[0]);
//                if (!jobHash.containsKey(split[1])) {
//                    degreeHash = new HashMap<>();
//                    foodHash = new HashMap<>();
//                    list = new ArrayList<>();
//                } else {
//                    degreeHash = jobHash.get(split[1]);
//                    if (!degreeHash.containsKey(split[2])) {
//                        foodHash = new HashMap<>();
//                        list = new ArrayList<>();
//                    } else {
//                        foodHash = degreeHash.get(split[2]);
//                        if (!foodHash.containsKey(split[3])) {
//                            list = new ArrayList<>();
//                        } else {
//                            list = foodHash.get(split[3]);
//                        }
//                    }
//                }
//            }
//            infos.put(split[0], jobHash);
//            jobHash.put(split[1], degreeHash);
//            degreeHash.put(split[2], foodHash);
//            foodHash.put(split[3], list);
//            list.add(Integer.parseInt(split[4]));
        }

        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" "); // 0,2,4,6,7

            String[] querys = {split[0], split[2], split[4], split[6], split[7]};
            String[] select = new String[querys.length];
            answer[i] = counter(querys, select, 0);

            System.out.printf("%12s%12s%12s%12s%12s\t::\t%s\n", split[0], split[2], split[4], split[6], split[7], answer[i]);
        }

        return answer;
    }

    public static int counter(String[] query, String[] select, int idx) {
        int cnt = 0;

        if (idx == 4) {
            ArrayList<Integer> list = infos.get(select[0]).get(select[1]).get(select[2]).get(select[3]);
            if (query[4].equals("-")) {
                cnt += list.size();
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) >= Integer.parseInt(query[4])) {
                        cnt++;
                    }
                }
            }
        } else {
            Iterator<String> iter = null;
            if (idx == 0) {
                iter = infos.keySet().iterator();
            } else if (idx == 1) {
                iter = infos.get(select[0]).keySet().iterator();
            } else if (idx == 2) {
                iter = infos.get(select[0]).get(select[1]).keySet().iterator();
            } else if (idx == 3) {
                iter = infos.get(select[0]).get(select[1]).get(select[2]).keySet().iterator();
            }

            while (iter.hasNext()) {
                String key = iter.next();
                if (query[idx].equals("-")) {
                    select[idx] = key;
                    cnt += counter(query, select, idx + 1);
                    select[idx] = "";
                } else {
                    if (query[idx].equals(key)) {
                        select[idx] = key;
                        cnt += counter(query, select, idx + 1);
                        select[idx] = "";
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }
}

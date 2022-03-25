package programmers.KakaoInternship2020;

import java.util.*;

public class Ex04_01_failed {
    public class Gem implements Comparable<Gem> {
        int idx;
        String name;

        public Gem(int idx, String name) {
            this.idx = idx;
            this.name = name;
        }

        @Override
        public int compareTo(Gem gem) {
            return this.idx - gem.idx;
        }
    }

    public int[] solution(String[] gems) {
        HashSet<String> all = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            all.add(gems[i]);
        }

        int maxIdx = 1000000;
        int minIdx = 0;
        boolean minRefresh = true;
        HashSet<String> have = new HashSet<>();
        PriorityQueue<Gem> pq = new PriorityQueue<>();
        for (int i = 0; i < gems.length; i++) {
            while (!pq.isEmpty() && pq.peek().name.equals(gems[i])) {
//                System.out.println("SAME POLL");
                pq.poll();
                minRefresh=true;
            }
            pq.offer(new Gem(i, gems[i]));

            while (pq.size() > 1) {
                Gem min = pq.poll();
                if (!min.name.equals(pq.peek().name)) {
                    pq.offer(min);
                    minRefresh=true;
                    break;
                }
//                System.out.println("MIN POLL");
            }

            have.add(gems[i]);
//            System.out.println(i+"::"+gems[i]+">>"+all.size()+"=="+have.size());
            if (minRefresh && all.size() == have.size()) {
                PriorityQueue<Gem> tmppq = new PriorityQueue<>();
                tmppq.addAll(pq);
                HashSet<String> set = new HashSet<>();
                set.addAll(have);

                int minTmp = tmppq.peek().idx;
                int maxTmp = 0;
                while (!tmppq.isEmpty() && !set.isEmpty()) {
                    Gem gem = tmppq.poll();
                    if (set.contains(gem.name)) {
                        set.remove(gem.name);
                        maxTmp=gem.idx;
                    }
                }

//                System.out.println("FIND : " + minTmp + " " + maxTmp);
                if (maxTmp - minTmp < maxIdx - minIdx) {
                    maxIdx = maxTmp;
                    minIdx = minTmp;
//                    System.out.println("MIN CHANGE : " + minIdx + " " + maxIdx);
                    minRefresh=false;
                }
            }
        }

        int[] answer = {minIdx+1, maxIdx+1};


        return answer;
    }

    public static void main(String[] args) {
        Ex04_01_failed main = new Ex04_01_failed();
        System.out.println(Arrays.toString(main.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println(Arrays.toString(main.solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
        System.out.println(Arrays.toString(main.solution(new String[]{"d","r","r","r","e","d","r","r"})));
//        System.out.println(Arrays.toString(main.solution(new String[]{})));
    }
}

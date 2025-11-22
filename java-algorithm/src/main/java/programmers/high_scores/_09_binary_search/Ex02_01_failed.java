package programmers.high_scores._09_binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ex02_01_failed {
    public static class DistComparator implements Comparator<Dist> {
        @Override
        public int compare(Dist dist1, Dist dist2) {
            if (dist1.dist == dist2.dist) return dist1.idx - dist2.idx;
            return dist1.dist - dist2.dist;
        }
    }

    public static class Dist {
        int dist;
        int idx;
        boolean isRemove;

        public Dist(int dist, int idx) {
            this.dist = dist;
            this.idx = idx;
            isRemove=false;
        }
    }

    public static int removeRock(Dist[] dist, ArrayList<Dist> distList, int n) {
        int remove = 0;
        while (remove != n) {
            Collections.sort(distList, new DistComparator());

//            System.out.println("=====PRINT=====");
//            for (int i = 0; i < distList.size(); i++) {
//                System.out.print(distList.get(i).dist+" ");
//            }
//            System.out.println();

            Dist minDist = distList.get(0);
//            System.out.println(minDist.idx+" : "+minDist.dist+" REMOVE");
            distList.remove(0);
            minDist.isRemove=true;
            remove++;

            int targetIdx = -1;
            for (int i = minDist.idx+1; i < dist.length; i++) {
                if (!dist[i].isRemove) {
                    targetIdx = dist[i].idx;
                    break;
                }
            }

            dist[targetIdx].dist += minDist.dist;
        }

        Collections.sort(distList, new DistComparator());
//        for (int i = 0; i < distList.size(); i++) {
//            System.out.println(distList.get(i).idx+" "+distList.get(i).dist);
//        }
        return distList.get(0).dist;
    }

    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        ArrayList<Dist> distList = new ArrayList<>();
        Dist[] dist = new Dist[rocks.length + 1];
        dist[0] = new Dist(rocks[0], 0);
        distList.add(dist[0]);
        for (int i = 1; i < rocks.length; i++) {
            dist[i] = new Dist(rocks[i] - rocks[i - 1], i);
            distList.add(dist[i]);
        }
        dist[rocks.length] = new Dist(distance - rocks[rocks.length - 1], rocks.length);
        distList.add(dist[rocks.length]);

        int minDist = removeRock(dist, distList, n);
//        System.out.println(minDist);

        return minDist;
    }

    public static void main(String[] args) {
        solution(25, new int[]{2, 14, 11, 21, 17}, 5);
    }
}

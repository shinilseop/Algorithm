package programmers.high_scores._06_greedy;

import java.util.*;

public class Ex01 {
<<<<<<< Updated upstream
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        HashSet<Integer> losts = new HashSet<>();
        HashSet<Integer> reserves = new HashSet<>();
        for (int i = 0; i < lost.length; i++)
            losts.add(lost[i]);
        for (int j = 0; j < reserve.length; j++)
            reserves.add(reserve[j]);

        // 여벌 있으면서 잃어버린사람 체크
        Iterator<Integer> lostIter = losts.iterator();
        ArrayList<Integer> removeIdx = new ArrayList<>();
        while (lostIter.hasNext()) {
            int num = lostIter.next();

            if (reserves.contains(num)) {
//                System.out.println(num+" lost and reserve");
                removeIdx.add(num);
                answer++;
            }
        }
        for (Integer idx : removeIdx) {
            losts.remove(idx);
            reserves.remove(idx);
        }

        // 이제 없는 사람 중 뒷번호가 있는사람 체크
        lostIter = losts.iterator();
        while (lostIter.hasNext()) {
            int num = lostIter.next();

            if (reserves.contains(num-1)) {
                reserves.remove(num-1);
                answer++;
            } else if (reserves.contains(num+1)) {
                reserves.remove(num+1);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] lost = {2, 3, 4};
        int[] reserve = {1, 2, 3, 6};

        System.out.println(solution(n, lost, reserve));
    }
=======
        
>>>>>>> Stashed changes
}

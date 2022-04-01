package programmers.Kakao.Kakao2019_Winter_Internship;

public class Ex05_02_binarySearch {
    static int[] stones;
    static int k;

    public int binarySearch() {
        int lo=1, hi = 200000000;

        while (lo<hi) {
            int mid = (lo+hi)/2;//건넌 친구의 명수

            int count = 0;
            for (int i = 0; i < stones.length; i++) {
                if(stones[i]-(mid-1)<=0) count++;
                else count=0;
                if (count == k) {
                    break;
                }
            }

            if (count >= k) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        return lo-1;
    }

    public int solution(int[] stones, int k) {
        this.stones=stones;
        this.k=k;

        return binarySearch();
    }

    public static void main(String[] args) {
        Ex05_02_binarySearch main = new Ex05_02_binarySearch();
        System.out.println(main.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
}

package programmers.Kakao.Kakao2022_Blind_Recruitment;

public class FindNumberInKSeries {
    public static void main(String[] args) {
        System.out.println(solution(7, 2));
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
//        String s = "123";
//        System.out.println(s.substring(0, 3));

    }

    public static int solution(int n, int k) {
        int answer = 0;

        String s = toKSeries(n, k);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                int lastIdx = findLast(s, i);
                long sub = Long.parseLong(s.substring(i, lastIdx));

                if (isPrime(sub)) {
                    answer++;
                }

                i = lastIdx;
            }
        }

        return answer;
    }

    public static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        } else if (num == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int findLast(String key, int start) {
        int idx = start + 1;
        while (idx < key.length()) {
            if (key.charAt(idx) == '0') {
                break;
            }
            idx++;
        }
        return idx;
    }

    public static String toKSeries(int num, int k) {
        StringBuilder result = new StringBuilder();

        while (true) {
            if (num / k > 0) {
                result.append(num % k);
                num /= k;
            } else {
                result.append(num);
                break;
            }
        }

        return result.reverse().toString();
    }
}

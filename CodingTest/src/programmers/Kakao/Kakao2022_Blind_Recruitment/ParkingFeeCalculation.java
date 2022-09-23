package programmers.Kakao.Kakao2022_Blind_Recruitment;

import java.util.*;

public class ParkingFeeCalculation {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> sum = new HashMap<>();
        Map<String, String> in = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i], " ");
            String time = st.nextToken();
            String number = st.nextToken();
            String type = st.nextToken();

            if (type.equals("IN")) {
                in.put(number, time);
            } else {
                String inTime = in.remove(number);
                String[] inTimeS = inTime.split(":");
                String[] outTimeS = time.split(":");
//                System.out.println(number+" >> "+inTime+" to "+time);
                int hour = Integer.parseInt(outTimeS[0]) - Integer.parseInt(inTimeS[0]);
                int min = Integer.parseInt(outTimeS[1]) - Integer.parseInt(inTimeS[1]);
                int minSum = hour * 60 + min;
                sum.put(number, sum.getOrDefault(number, 0) + minSum);
            }
        }

        int maxHour = 23;
        int maxMin = 59;
        for (String key : in.keySet()) {
            String inTime = in.get(key);
            String[] inTimeS = inTime.split(":");
//            System.out.println(key+" >> "+inTime+" to "+maxHour+":"+maxMin);
            int hour = maxHour - Integer.parseInt(inTimeS[0]);
            int min = maxMin - Integer.parseInt(inTimeS[1]);
            int minSum = hour * 60 + min;
            sum.put(key, sum.getOrDefault(key, 0) + minSum);
        }

        List<String> keySort = new ArrayList<>();
        for (String key : sum.keySet()) {
            keySort.add(key);
        }
        Collections.sort(keySort);

        int[] answer = new int[keySort.size()];
        for (int i = 0; i < keySort.size(); i++) {
            int min = sum.get(keySort.get(i));
            if (min > fees[0]) {
//                System.out.println(keySort.get(i) + " : " + fees[1]+ " + ["+min+" - "+fees[0]+"] / "+fees[2]+" * "+fees[3]);
//                System.out.println((double)(min - fees[0]) / fees[2]);
//                System.out.println(Math.ceil((double)(min - fees[0]) / fees[2]));
                answer[i] = fees[1] + ((int) Math.ceil((double)(min - fees[0]) / fees[2]) * fees[3]);
            } else {
//                System.out.println(keySort.get(i) + " : " +fees[1]);
                answer[i] = fees[1];
            }
        }

        return answer;
    }
}


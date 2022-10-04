package programmers.Kakao.Kakao2021_Blind_Recruitment;

public class ex05_AdvertisementInsert2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.toSecond("00:59:59"));

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(solution.solution(play_time, adv_time, logs));
    }


    static class Solution {
        int[] times;

        public String solution(String play_time, String adv_time, String[] logs) {
            times = new int[toSecond(play_time) + 1];
            int advTime = toSecond(adv_time);

            for (String log : logs) {
                String[] split = log.split("-");
                int startTime = toSecond(split[0]);
                int endTime = toSecond(split[1]);

                times[startTime] += 1;
                times[endTime] -= 1;
            }

            long answer = times[0];
            int startIdx = 0;
            for (int i = 1; i <= advTime; i++) {
                times[i] += times[i - 1];
                answer += times[i];
            }

            long tmp = answer;
            for (int i = advTime + 1; i < times.length; i++) {
                times[i] += times[i - 1];
                tmp += times[i];
                tmp -= times[i - advTime];
                if (tmp > answer) {
                    answer = tmp;
                    startIdx = i - advTime + 1;
                }
            }

            return toTime(startIdx);
        }

        public int toSecond(String time) {
            String[] split = time.split(":");
            int sum = Integer.parseInt(split[0]) * 60 * 60;
            sum += Integer.parseInt(split[1]) * 60;
            sum += Integer.parseInt(split[2]);

            return sum;
        }

        public String toTime(long second) {
            long sec = second % 60;
            second -= second % 60;
            second /= 60;
            long min = second % 60;
            second -= second % 60;
            long hour = second / 60;

            String time = "";
            if (hour < 10) {
                time += "0" + hour;
            } else {
                time += String.valueOf(hour);
            }
            time += ":";

            if (min < 10) {
                time += "0" + min;
            } else {
                time += String.valueOf(min);
            }
            time += ":";

            if (sec < 10) {
                time += "0" + sec;
            } else {
                time += String.valueOf(sec);
            }

            return time;
        }
    }
}
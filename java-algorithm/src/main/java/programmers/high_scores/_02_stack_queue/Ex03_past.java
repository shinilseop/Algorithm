package programmers.high_scores._02_stack_queue;

public class Ex03_past {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {

            int answer = 0;
            int idx = 0;
            int nowweight = 0;
            int timesum = 0;
            int[] time = new int[truck_weights.length];

            nowweight += truck_weights[idx];
            time[idx]++;
            idx=1;
            timesum++;

            for(;;){
                for(int i=0;i<time.length;i++){
                    if(0 < time[i] && time[i] < bridge_length){
                        time[i]++;
                    }else if(time[i] == bridge_length){
                        time[i]++;
                        nowweight-=truck_weights[i];
                    }
                }
                if(idx != truck_weights.length){
                    if(nowweight + truck_weights[idx] <= weight){
                        nowweight+=truck_weights[idx];
                        time[idx]++;
                        idx++;
                    }
                }
                timesum++;
                if(time[time.length-1] == bridge_length+1)
                    break;
            }

            answer = timesum;

            return answer;
        }
    }
}

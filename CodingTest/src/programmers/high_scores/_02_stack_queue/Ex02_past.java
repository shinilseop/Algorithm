package programmers.high_scores._02_stack_queue;

public class Ex02_past {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            int idx = 0;
            boolean print = false;
            boolean change = false;

            for(;;){
                change = false;
                for(int i=idx+1;i<priorities.length;i++){
                    if(priorities[idx] < priorities[i]){
                        change=true;
                        int temp = priorities[idx];
                        for(int j=idx+1;j<priorities.length;j++)
                            priorities[j-1] = priorities[j];
                        priorities[priorities.length-1] = temp;
                        if(location==idx)
                            location = priorities.length-1;
                        else
                            location--;
                    }
                }
                if(!change){
                    if(idx == location)
                        break;
                    else
                        idx++;
                }
            }
            answer = location+1;
            return answer;
        }
    }
}

package programmers.high_scores._02_stack_queue;

import java.util.ArrayList;

public class Ex01_past {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            int idx = 0, temp = 0;
            boolean[] distribute = new boolean[progresses.length];
            ArrayList<Integer> ans = new ArrayList<Integer>();

            for(;;){
                if(idx == progresses.length)
                    break;
                if(progresses[idx] >= 100){
                    System.out.println();
                    System.out.println(progresses[idx]+" "+idx);
                    if(idx == progresses.length-1){
                        ans.add(1);
                        idx++;
                    } else{
                        for(int j=idx+1;j<progresses.length;j++){
                            if(progresses[j]>=100)
                                temp = j;
                            else{
                                temp = j-1;
                                break;
                            }
                        }
                        ans.add(temp-idx+1);
                        idx = temp+1;
                    }
                    System.out.println(idx);
                }
                System.out.println();
                for(int i=idx;i<progresses.length;i++){
                    progresses[i]+=speeds[i];
                    System.out.print(progresses[i]+" ");
                }
            }
            System.out.println();
            int[] arr = new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                System.out.print(arr[i]+" ");
                arr[i] = ans.get(i);
            }
            answer = arr;
            return answer;
        }
    }
}

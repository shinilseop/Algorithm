package programmers.high_scores._01_hash;

import java.util.ArrayList;

class Solution03 {
    public int solution(String[][] clothes) {
        int answer = 1;
        ArrayList<String> kind = new ArrayList<String>();


        for(int i=0;i<clothes.length;i++){
            if(!kind.contains(clothes[i][1])){
                kind.add(clothes[i][1]);
            }
        }

        int[] tno = new int[kind.size()];

        for(int i=0;i<clothes.length;i++){
            tno[kind.indexOf(clothes[i][1])]++;
        }

        for(int i=0;i<tno.length;i++){
            answer*=tno[i]+1;
        }


        return answer-1;
    }
}

public class Ex03_past {
}

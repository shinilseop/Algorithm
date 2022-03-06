package programmers.high_scores._06_greedy;

public class Ex03_past {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int idx = 0;
        int len = 0;
        char[] num = new char[number.length()];


        for(int i=0;i<number.length();i++)
            num[i] = number.charAt(i);

        while(true){
            for(int i=idx+1;i<num.length-(number.length()-k)+len+1;i++){
                if(num[idx] < num[i]) {
                    idx = i;
                }
            }
            sb.append(num[idx]);
            idx++;
            len++;
            if(len == number.length()-k)
                break;
        }
        answer = sb.toString();
        return answer;
    }
}

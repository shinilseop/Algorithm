package programmers.high_scores._08_dfs_bfs;

public class Ex04_past {
    boolean[] use;
    String[] temp;
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        temp = new String[tickets.length+1];
        use = new boolean[tickets.length];

        for(int i=0;i<temp.length;i++){
            temp[i] = "ZZZ";
        }

        answer[0] = "ICN";
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN") && !use[i]){
                use[i] = true;
                answer[1] = tickets[i][1];
                fly(tickets, answer, i, 2);
                use[i] = false;
            }
        }
        answer = temp;

        return answer;
    }
    public void fly(String[][] tickets, String[] answer, int n, int useT){
        if(useT == tickets.length+1){
            for(int j=0;j<temp.length;j++){
                if(temp[j].compareTo(answer[j]) < 0)
                    break;
                if(temp[j].compareTo(answer[j]) > 0){
                    for(int i=0;i<temp.length;i++)
                        temp[i] = answer[i];
                    break;
                }
            }
            return;
        }

        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals(tickets[n][1]) && !use[i]){
                use[i] = true;
                answer[useT] = tickets[i][1];
                fly(tickets, answer, i, useT+1);
                use[i] = false;
            }
        }
        return;
    }
}

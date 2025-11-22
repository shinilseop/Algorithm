package programmers.high_scores._08_dfs_bfs;

public class Ex03_past {
    int min = 9999;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean match = false;
        for(int i=0;i<words.length;i++)
            if(target.equals(words[i]))
                match = true;
        if(!match)
            return 0;

        dfs(begin, target, words, 0);
        answer = min;

        return answer;
    }
    public void dfs(String begin, String target, String[] words, int level){
        if(begin.equals(target)){
            if(min > level)
                min = level;
            return;
        }

        String[] tmp = new String[words.length - 1];
        for(int i=0;i<words.length;i++){
            int diff = 0;
            for(int j=0;j<begin.length();j++){
                if(words[i].charAt(j) != begin.charAt(j))
                    diff++;
            }
            if(diff == 1){
                int idx = 0;
                for(int j=0;j<words.length;j++){
                    if(j != i){
                        tmp[idx] = words[j];
                        idx++;
                    }
                }

                dfs(words[i], target, tmp, level+1);
            }
        }
        return;
    }
}

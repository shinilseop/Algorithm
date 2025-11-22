package programmers.high_scores._08_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Ex03 {
    static boolean[] visited;
    String[] words;

    public class Word {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public boolean canConvert(String word, String convert) {
        boolean isDiff = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != convert.charAt(i)) {
                if (isDiff) {
                    return false;
                }
                isDiff=true;
            }
        }

        return true;
    }

    public int bfs(String begin, String target) {
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));

        while (!q.isEmpty()) {
            Word word = q.poll();

            if (word.word.equals(target)) {
                return word.cnt;
            }
            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    if (canConvert(word.word, words[i])) {
                        visited[i] = true;
                        q.offer(new Word(words[i], word.cnt + 1));
                    }
                }
            }
        }

        return 0;
    }

    public int solution(String begin, String target, String[] words) {
        this.words = words;
        visited = new boolean[words.length];

        int answer = bfs(begin, target);

        return answer;
    }
}

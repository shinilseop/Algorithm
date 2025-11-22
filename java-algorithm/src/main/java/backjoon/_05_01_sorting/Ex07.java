package backjoon._05_01_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ex07 {
    static class Word implements Comparable<Word> {
        String word;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if (word.length() > o.word.length()) {
                return 1;
            } else if(word.length() == o.word.length()) {
                return word.compareTo(o.word);
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        Word[] w = new Word[_loop];
        int lengths = 0;
        for (int i = 0; i < _loop; i++) {
            w[i] = new Word(br.readLine());
            lengths += w[i].word.length();
        }
        Arrays.sort(w);
        StringBuilder sb = new StringBuilder(lengths + _loop);
//        IntStream.range(0, w.length).mapToObj(i->w[i].word).distinct().forEach(str->{
//            sb.append(str).append("\n");
//        });
        Stream.of(w).map(word->word.word).distinct().forEach(str->{
            sb.append(str).append("\n");
        });
        System.out.println(sb);
    }
}

package programmers.high_scores._01_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Ex04_past {
    public class Solution {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer;

            ArrayList<Genre> sump = new ArrayList<>();
            sump.add(new Genre(genres[0], plays[0]));
            int cnt=1;
            for (int i = 1; i < genres.length; i++) {
                for (int j = 0; j < sump.size(); j++) {
                    if (sump.get(j).genre.equals(genres[i])) {
                        sump.get(j).addplay(plays[i]);
                        break;
                    }
                    if (j == sump.size() - 1) {
                        sump.add(new Genre(genres[i], plays[i]));
                        break;
                    }
                }
            }
            Collections.sort(sump);
            Map<String, ArrayList<Song1>> hm = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (hm.containsKey(genres[i])) {
                    hm.get(genres[i]).add(new Song1(genres[i], plays[i], i));
                } else {
                    hm.put(genres[i], new ArrayList<Song1>());
                    hm.get(genres[i]).add(new Song1(genres[i], plays[i], i));
                }
            }

            ArrayList<Integer> tmpAns=new ArrayList<>();
            int idx=0;
            for (int i = 0; i < sump.size(); i++) {
                int leng = hm.get(sump.get(i).genre).size();
                Collections.sort(hm.get(sump.get(i).genre));
                for (int j = 0; j < leng; j++) {
                    if(j==2)
                        break;
                    int s = hm.get(sump.get(i).genre).get(j).serial;
                    tmpAns.add(s);
                }
            }

            answer=new int[tmpAns.size()];
            for(int i=0;i<tmpAns.size();i++	) {
                answer[i]=tmpAns.get(i);
            }

            return answer;
        }
    }

    class Genre implements Comparable<Genre> {
        String genre;
        int play;

        Genre(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }

        public int compareTo(Genre g) {
            if (this.play > g.play) {
                return -1;
            } else if (this.play < g.play) {
                return 1;
            } else {
                return 0;
            }
        }

        void addplay(int num) {
            this.play += num;
        }
    }

    class Song1 implements Comparable<Song1> {
        String genre;
        int play;
        int serial;

        Song1(String genre, int play, int serial) {
            this.genre = genre;
            this.play = play;
            this.serial = serial;
        }

        public int compareTo(Song1 s) {
            if (this.play > s.play) {
                return -1;
            } else if (this.play < s.play) {
                return 1;
            } else {
                if (this.serial > s.serial) {
                    return 1;
                } else if (this.serial < s.serial) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}

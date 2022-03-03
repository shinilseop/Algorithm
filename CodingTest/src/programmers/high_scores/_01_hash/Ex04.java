package programmers.high_scores._01_hash;

import java.util.*;

public class Ex04 {
    public static class Song implements Comparable<Song> {
        int played;
        int idx;


        Song(int played, int idx) {
            this.played = played;
            this.idx = idx;
        }

        @Override
        public int compareTo(Song song) {
            if (this.played != song.played) {
                return -(this.played - song.played);
            } else {
                return this.idx - song.idx;
            }
        }
    }

    public static class Genre implements Comparable<Genre> {
        int played;
        String name;

        Genre(int played, String name) {
            this.played =played;
            this.name = name;
        }

        @Override
        public int compareTo(Genre genre) {
            return -(this.played - genre.played);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreCnt = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0) + plays[i]);
        }

        int idx = 0;
        Genre[] g = new Genre[genreCnt.size()];
        Iterator<String> iter = genreCnt.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            g[idx++] = new Genre(genreCnt.get(key), key);
        }
        Arrays.sort(g);


        HashMap<String, ArrayList<Song>> songs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (songs.containsKey(genres[i])) {
                songs.get(genres[i]).add(new Song(plays[i], i));
            } else {
                ArrayList<Song> tmp = new ArrayList<>();
                tmp.add(new Song(plays[i], i));
                songs.put(genres[i], tmp);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < g.length; i++) {
            ArrayList<Song> s = songs.get(g[i].name);
            Collections.sort(s);
            int len = s.size()==1?1:2;
            for (int j = 0; j < len; j++) {
                ans.add(s.get(j).idx);
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }
}

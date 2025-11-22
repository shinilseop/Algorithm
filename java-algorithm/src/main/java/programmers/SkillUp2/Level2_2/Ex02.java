package programmers.SkillUp2.Level2_2;

import java.util.ArrayList;

public class Ex02 {
    public int getMin(String start, String end) {
        int hour = Integer.parseInt(end.substring(0, 2)) - Integer.parseInt(start.substring(0, 2));
        int minute = Integer.parseInt(end.substring(3, 5)) - Integer.parseInt(start.substring(3, 5));
        return hour * 60 + minute;
    }

    public String getPlayed(int time, String lyric) {
        int melodyLen = lyric.length();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < time; i++) {
            sb.append(lyric.charAt(i % melodyLen));
        }

        return sb.toString();
    }

    public String solution(String m, String[] musicinfos) {
        String song = "(None)";
        int min=0;
        m=m.replaceAll("C#", "1").replaceAll("D#", "2").replaceAll("F#", "3").replaceAll("G#", "4").replaceAll("A#", "5");

        for (int i = 0; i < musicinfos.length; i++) {
            String[] inputs = musicinfos[i].split(",");
            int minute = getMin(inputs[0], inputs[1]);
            String melody = getPlayed(minute, inputs[3].replaceAll("C#", "1").replaceAll("D#", "2").replaceAll("F#", "3").replaceAll("G#", "5").replaceAll("A#", "4"));
            System.out.println(minute+" : "+melody);
            if (melody.contains(m) && min < minute) {
                song = inputs[2];
                min = minute;
            }
        }

        return song;
    }

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        Ex02 main = new Ex02();
        System.out.println(main.solution(m, musicinfos));
    }
}

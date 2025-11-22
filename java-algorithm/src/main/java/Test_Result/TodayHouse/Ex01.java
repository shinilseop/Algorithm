package Test_Result.TodayHouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Ex01 {
    public class Path  {
        char dir;
        int move;

        public Path(char dir, int move) {
            this.dir=dir;
            this.move=move;
        }
    }

    public String[] solution(String path) {
        HashMap<String, String> dir = new HashMap<>();
        dir.put("ES", "right");
        dir.put("EN", "left");
        dir.put("WS", "left");
        dir.put("WN", "right");
        dir.put("SW", "left");
        dir.put("SE", "right");
        dir.put("NW", "right");
        dir.put("NE", "left");

        ArrayList<Path> paths = new ArrayList<>();
        paths.add(new Path(path.charAt(0), 1));
        for (int i = 1; i < path.length(); i++) {
            if (paths.get(paths.size() - 1).dir == path.charAt(i)) {
                paths.get(paths.size() - 1).move++;
            } else {
                paths.add(new Path(path.charAt(i), 1));
            }
        }

        int time = 0;
        String[] answer = new String[paths.size() - 1];
        for (int i=0;i<paths.size()-1;i++) {
            Path p = paths.get(i);
            if (p.move > 5) {
                time+=p.move-5;
                answer[i]=("Time " + time + ": " + "Go straight 500m and turn " + dir.get(new String(new char[]{p.dir, paths.get(i + 1).dir})));
                time+=5;
            } else {
                answer[i]=("Time " + time + ": " + "Go straight " + p.move + "00m and turn " + dir.get(new String(new char[]{p.dir, paths.get(i + 1).dir})));
                time+=p.move;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex01 main = new Ex01();
        System.out.println(Arrays.toString(main.solution("EEESEEEEEENNNN")));
    }
}

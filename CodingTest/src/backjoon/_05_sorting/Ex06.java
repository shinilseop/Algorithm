package backjoon._05_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Ex06 {
    static class Point implements Comparable<Point> {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.y > o.y){
                return 1;
            } else if (this.y == o.y) {
                if (this.x > o.x) {
                    return 1;
                } else if (this.x == o.x) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        Point p[] = new Point[_loop];
        for (int i = 0; i < _loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(p);
        StringBuilder sb = new StringBuilder(_loop*4);
        IntStream.range(0, p.length).forEach(i->{
            sb.append(p[i].x).append(" ").append(p[i].y).append("\n");
        });
        System.out.println(sb.toString());
    }
}

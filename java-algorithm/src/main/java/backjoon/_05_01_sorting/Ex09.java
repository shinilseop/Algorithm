package backjoon._05_01_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Ex09 {
    static class Point implements Comparable<Point> {
        int x;
        int beforeIdx;
        int order;

        public Point(int x, int beforeIdx) {
            this.x = x;
            this.beforeIdx = beforeIdx;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x > o.x) {
                return 1;
            } else if (this.x == o.x) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        Point p[] = new Point[_loop];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < _loop; i++) {
            p[i] = new Point(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(p);
        p[0].order = 0;
        for (int i = 1; i < p.length; i++) {
            if(p[i].x == p[i-1].x){
                p[i].order = p[i-1].order;
            } else {
                p[i].order = p[i-1].order+1;
            }
        }
        int[] output = new int[_loop];
        IntStream.range(0, p.length).forEach(i->{
            output[p[i].beforeIdx] = p[i].order;
        });

        StringBuilder sb = new StringBuilder(_loop*2);
        sb.append(output[0]);
        IntStream.range(1, output.length).forEach(i->sb.append(" "+output[i]));
        System.out.println(sb);
    }
}

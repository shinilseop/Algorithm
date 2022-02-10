package backjoon._02_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        double dist = Integer.MAX_VALUE;
        if (0 <= x && x <= w) {
            if (0 <= y && y <= h) {
                dist = Math.min(x, Math.min(y, Math.min(w - x, h - y)));
            } else {
                dist = y >= 0 ? y - h : Math.abs(y);
            }
        } else if (0 < y && y < h) {
            dist = x >= 0 ? x - w : Math.abs(x);
        } else {
            if (x > 0 && y > 0) {
                dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            } else if (x < 0 && y > 0) {
                dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y - h, 2));
            } else if (x > 0 && y < 0) {
                dist = Math.sqrt(Math.pow(x - w, 2) + Math.pow(y, 2));
            } else if (x < 0 && y < 0) {
                dist = Math.sqrt(Math.pow(x - w, 2) + Math.pow(y - h, 2));
            }
        }

        System.out.println((int)dist);
    }
}

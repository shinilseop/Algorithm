package backjoon._02_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        while (_loop-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (r2 < r1) {
//                System.out.println("Swap");
                int tmp = x1;
                x1 = x2;
                x2 = tmp;

                tmp = y1;
                y1 = y2;
                y2 = tmp;

                tmp = r1;
                r1 = r2;
                r2 = tmp;
            }

            double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//            System.out.println("Dist : "+dist);
            if (x1 == x2 && y1 == y2) { // 동심원
                if (r1 == r2) {
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }
            } else if (dist == r2) { // 큰원위에 작은원 중심
                System.out.println(2);
            } else if (dist < r2) { // 큰원안에 작은원 중심
                if (r2 > r1 + dist) {
                    System.out.println(0);
                } else if (r2 == r1 + dist) {
                    System.out.println(1);
                } else if (r2 < r1 + dist) {
                    System.out.println(2);
                }
            } else { // 큰원밖에 작은원 중심
                if (r1 + r2 < dist) {
                    System.out.println(0);
                } else if (r1 + r2 == dist) {
                    System.out.println(1);
                } else if (r1 + r2 > dist) {
                    System.out.println(2);
                }
            }
        }
    }
}

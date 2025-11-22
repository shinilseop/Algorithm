package backjoon._04_bruteforece;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(_loop * 2);

        People[] p = new People[_loop];
        for (int i = 0; i < _loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i] = new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (i == j)
                    continue;

                if (p[i].kg < p[j].kg && p[i].tall < p[j].tall) {
                    p[i].degree++;
                }
            }

            sb.append(p[i].degree).append(" ");
        }

        System.out.println(sb.toString());
    }

    static class People {
        int kg;
        int tall;
        int degree;

        public People(int kg, int tall) {
            this.kg = kg;
            this.tall = tall;
            this.degree = 1;
        }
    }
}

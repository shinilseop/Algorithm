package backjoon._05_02_set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ex01_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int before = set.size();
        int M = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(M*2);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
//            set.add(Integer.parseInt(st.nextToken()));
//            if (before != set.size()) {
//                before = set.size();
//                sb.append("0 ");
//            }  else {
//                sb.append("1 ");
//            }

            if (set.contains(Integer.parseInt(st.nextToken()))) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}

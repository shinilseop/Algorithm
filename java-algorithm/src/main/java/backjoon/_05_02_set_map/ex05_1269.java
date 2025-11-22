package backjoon._05_02_set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ex05_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            //            if (set.contains(num)) {
//                set.remove(num);
//            } else {
//                set.add(num);
//            }

            if (set.contains(num)) {
                cnt--;
            } else {
                cnt++;
                set.add(num);
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

//            if (set.contains(num)) {
//                set.remove(num);
//            } else {
//                set.add(num);
//            }

            if (set.contains(num)) {
                cnt--;
            } else {
                cnt++;
                set.add(num);
            }
        }

//        System.out.println(set.size());
        System.out.println(cnt);
    }
}

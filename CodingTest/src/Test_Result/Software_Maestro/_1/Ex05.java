package Test_Result.Software_Maestro._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex05 {
    // 1/3 지점 과 2/3 지점의 값 출력하기
    // 배열의 길이가 3*N + 2 로 고정

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        list.add(a);
        list.add(b);

        StringBuffer answer = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            list.add(n1);
            list.add(n2);
            list.add(n3);

            Collections.sort(list);

            int _3 = list.size()/3;
            System.out.println("idx"+_3+" "+_3*2);
            answer.append(list.get(_3)).append(' ').append(list.get(_3 * 2)).append('\n');
        }

        System.out.print(answer.toString().strip());
    }
}

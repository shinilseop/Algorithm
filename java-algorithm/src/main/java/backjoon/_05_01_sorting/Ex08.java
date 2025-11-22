package backjoon._05_01_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Ex08 {
    static class Member implements Comparable<Member> {
        int order;
        int age;
        String name;

        public Member(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age > o.age) {
                return 1;
            } else if (this.age == o.age) {
                if (this.order > o.order) {
                    return 1;
                } else if (this.order == o.order) {
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

        Member[] m = new Member[_loop];
        int size = 0;
        for (int i = 0; i < _loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m[i] = new Member(i, Integer.parseInt(st.nextToken()), st.nextToken());
            size += 3 + 1 + m[i].name.length();
        }

        Arrays.sort(m);

        StringBuilder sb = new StringBuilder(size);
        Stream.of(m).forEach(member -> sb.append(member.age+" ").append(member.name+"\n"));
        System.out.println(sb);
    }
}

package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    static StringBuffer sb;
    static int[][] input;
    static int size;

    public static void quadTree(int y, int x, int len) {
        if (len == 1) {
//            System.out.println("1 ADD "+input[y][x]);
            sb.append(input[y][x]);
            return;
        }

        int stand = input[y][x];
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (stand != input[i][j]) {
//                    System.out.println("DIFF "+i+", "+j+"="+input[i][j]);
                    sb.append('(');
                    quadTree(y, x, len/2);
                    quadTree(y, x+(len/2), len/2);
                    quadTree(y+(len/2), x, len/2);
                    quadTree(y+(len/2), x+(len/2), len/2);
                    sb.append(')');
                    return;
                }
            }
        }

//        System.out.println(len+" ADD "+input[y][x]);
        sb.append(stand);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        sb = new StringBuffer(size*size);
        input = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] video = (br.readLine()).split("");
            for (int j = 0; j < size; j++) {
                input[i][j] = Integer.parseInt(video[j]);
            }
        }

        quadTree(0, 0, size);
        System.out.println(sb.toString());
    }
}

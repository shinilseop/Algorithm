package Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCloningTest {
    public static void main(String[] args) {
        int[][] map = new int[3][3];
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = cnt++;
            }
        }

        int[][] temp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            temp[i] = map[i].clone();
        }

        temp[0][0] = 11;
        temp[1][1] = 11;
        temp[2][0] = 11;

        System.out.println(map[0][0]);
        System.out.println(map[1][1]);
        System.out.println(map[2][0]);
    }
}

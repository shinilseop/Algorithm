package backjoon._06_backtracking;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        boolean visited[][] = new boolean[3][3];
        visited[0][0] = true;
        visited[1][0] = true;

        boolean visited2[][] = new boolean[visited.length][];
        for(int i=0;i<visited.length;i++)
            visited2[i] = visited[i].clone();

        visited[0][0] = false;
        System.out.println(visited[0][0]+" "+visited2[0][0]);
    }
}

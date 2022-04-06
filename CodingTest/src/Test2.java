
import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[][] map;
    static boolean answer=false;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Point> list = new ArrayList<Point>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=9;
        map = new int[n][n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                int item = Integer.parseInt(str[j]);
                if(item == 0) list.add(new Point(i, j));
                map[i][j] = item;
            }
        }

        Point point = list.get(0);
        for(int i=1; i<n+1; i++){
            if(isNotContain(i, point)){
                point.visited = true;
                map[point.i][point.j] = i;
                inputNum(1);
            }
        }
    }


    public static void inputNum(int count){
        if(answer){
            return;
        }
        if(count==list.size()){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            answer= true;
            return;
        }
        Point point = list.get(count);
        for(int i=1; i<n+1; i++){
            if(isNotContain(i, point)){
                map[point.i][point.j] = i;
                inputNum(count+1);
                map[point.i][point.j] = 0;
            }
        }
        return;
    }
    public static boolean isNotContain(int num, Point point){
        //가로 검사
        for(int j=0; j<n; j++){
            if(j== point.j) continue;
            if(map[point.i][j] == num) return false;
        }
        //세로 검사
        for(int i=0; i<n; i++){
            if(i == point.i) continue;
            if(map[i][point.j] == num) return false;
        }
        // 3x3 범위 검사
        if(point.i >=0 && point.i < 3 && point.j >=0 && point.j <3){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(map[i][j] == num) return false;
                }
            }
        }
        else if(point.i >=0 && point.i < 3 && point.j >=3 && point.j <6){
            for(int i=0; i<3; i++){
                for(int j=3; j<6; j++){
                    if(map[i][j] == num) return false;
                }
            }
        }
        else if(point.i >=0 && point.i < 3 && point.j >=6 && point.j <9){
            for(int i=0; i<3; i++){
                for(int j=6; j<9; j++){
                    if(map[i][j] == num) return false;
                }
            }
        }
        else if(point.i >=3 && point.i < 6 && point.j >=0 && point.j <3){
            for(int i=3; i<6; i++){
                for(int j=0; j<3; j++){
                    if(map[i][j] == num) return false;
                }
            }
        }
        else if(point.i >=3 && point.i < 6 && point.j >=3 && point.j <6){
            for(int i=3; i<6; i++){
                for(int j=3; j<6; j++){
                    if(map[i][j] == num) return false;
                }
            }
        }
        else if(point.i >=3 && point.i < 6 && point.j >=6 && point.j <9){
            for(int i=3; i<6; i++){
                for(int j=6; j<9; j++){
                    if(map[i][j] == num) return false;
                }
            }
        }
        else if(point.i >=6 && point.i < 9 && point.j >=0 && point.j <3){
            for(int i=6; i<9; i++){
                for(int j=0; j<3; j++){
                    if(map[i][j] == num) return false;
                }
            }
        }
        else if(point.i >=6 && point.i < 9 && point.j >=3 && point.j <6){
            for(int i=6; i<9; i++){
                for(int j=3; j<6; j++){
                    if(map[i][j] == num) return false;
                }
            }
        }
        else if(point.i >=6 && point.i < 9 && point.j >=6 && point.j <9){
            for(int i=6; i<9; i++){
                for(int j=6; j<9; j++){
                    if(map[i][j] == num) return false;
                }
            }
        }
        return true;
    }
    static class Point{
        int i;
        int j;
        boolean visited;
        Point(int i, int j){
            this.i = i;
            this.j = j;
            this.visited = false;
        }
    }
}
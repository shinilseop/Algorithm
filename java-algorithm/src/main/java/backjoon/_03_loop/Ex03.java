package backjoon._03_loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Ex03 {
    static char[][] printStar(int num) {
        if (num == 3) {
            return new char[][]{
                    {'*','*','*'},
                    {'*',' ','*'},
                    {'*','*','*'}};
        }

        char[][] draw = new char[num][num];
        int drawCnt = 0;
        for (int i = 0; i < num; i += num / 3) {
            for (int j = 0; j < num; j += num / 3) {
                drawCnt++;
                if(drawCnt == 5){
                    for (int x = 0; x < num/3; x++) {
                        for (int y = 0; y < num/3; y++) {
                            draw[i+x][j+y] = ' ';
                        }
                    }
                } else {
                    char[][] drawTmp = printStar(num/3);
                    for (int x = 0; x < drawTmp.length; x++) {
                        for (int y = 0; y < drawTmp.length; y++) {
                            draw[i+x][j+y] = drawTmp[x][y];
                        }
                    }
                }

            }
        }

        return draw;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        char[][] stars = printStar(num);
        Stream.of(stars).forEach(System.out::println);
    }
}

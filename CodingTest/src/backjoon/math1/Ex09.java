package backjoon.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        while (_loop-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = (y-x);
            if(dist == 1) {
                System.out.println(1);
                continue;
            } else if(dist==3){
                System.out.println(3);
                continue;
            }

            int pos = 1;
            int moveDist = 2;
            int moveCnt = 1;
            while (true) {
                if(dist/2 == pos){
                    System.out.println(moveCnt*2);
                    break;
                } else if(dist/2 < pos+moveDist) {
//                    System.out.println("over pos:"+pos+", moveDist:"+moveDist+", moveCnt:"+moveCnt);
                   if(moveDist >= (dist-pos)-pos){
                       System.out.println(moveCnt*2+1);
                   } else {
                       System.out.println(moveCnt*2+2);
                   }
                   break;
                }

                pos += moveDist;
                moveCnt++;
                moveDist++;
            }
        }
    }
}

package backjoon._02_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1x = Integer.parseInt(st.nextToken());
        int p1y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p2x = Integer.parseInt(st.nextToken());
        int p2y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p3x = Integer.parseInt(st.nextToken());
        int p3y = Integer.parseInt(st.nextToken());

        int p4x = 0;
        int p4y = 0;

        if(p1x==p2x){
            p4x = p3x;
        } else if(p1x==p3x){
            p4x = p2x;
        } else {
            p4x = p1x;
        }

        if(p1y==p2y){
            p4y = p3y;
        } else if(p1y==p3y){
            p4y = p2y;
        } else {
            p4y = p1y;
        }

        System.out.println(p4x+" "+p4y);
    }
}

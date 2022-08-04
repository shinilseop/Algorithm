package backjoon.others;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swexp_1225 {
    public static String stringMaker(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(i + "\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("aa");


        System.out.print(sb);
    }
}

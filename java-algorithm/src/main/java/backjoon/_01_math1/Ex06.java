package backjoon._01_math1;

import java.io.*;

public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());
        int apartment[][] = new int[15][15];
        for (int i = 0; i < apartment.length; i++) {
            for (int j = 1; j < apartment.length; j++) {
                if (i == 0) {
                    apartment[i][j] = j;
                } else {
                    apartment[i][j] = apartment[i][j-1] + apartment[i-1][j];
                }
//                System.out.printf("%10d", apartment[i][j]);
            }
//            System.out.println();
        }


        while (_loop-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(apartment[k][n]);
        }
    }
}

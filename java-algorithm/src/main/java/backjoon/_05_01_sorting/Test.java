package backjoon._05_01_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int mid, fre = 0, tmpfre = 0, frevalue = 0;
    static double avg = 0;
    static int num[] = new int[8001];
    static int sorted[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        sorted = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            num[tmp + 4000]++;
            /*
             * max = Math.max(max, tmp); min = Math.min(min, tmp);
             */
            avg += tmp;
        }
        int idx = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                if (frevalue < num[i]) {
                    frevalue = num[i];
                    fre = i-4000;
                    tmpfre = -10000;
                } else if (frevalue == num[i] && tmpfre == -10000) {
                    frevalue=num[i];
                    tmpfre = i-4000;
                }
                sorted[idx++] = i - 4000;
                num[i]--;
                i--;
            }
        }
        if(tmpfre != -10000) {
            fre = tmpfre;
        }
        if(avg > 0) {
            avg= avg/(double)n;
            avg= (int)(((avg*10)+5)/10);
        } else if(avg < 0) {
            avg= avg/(double)n;
            avg= (int)(((avg*10)-5)/10);
        }

        System.out.println((int)avg);
        System.out.println(sorted[n / 2]);
        System.out.println(fre);
        System.out.println(sorted[n - 1] - sorted[0]);
    }
}
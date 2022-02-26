package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex09_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            if (size == 0) {
                break;
            }

            int[] hist = new int[size];
            for (int i = 0; i < size; i++) {
                hist[i] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            long max = 0;
            boolean isFind = true;
            while (isFind) {
                long height = hist[idx];
                long width = 1;
                isFind = false;
//                System.out.println(idx+" START "+height);
                for (int j = idx+1; j < size; j++) {
                    if(height == hist[j]) {
//                        System.out.println("NEXT is SAME idx="+(idx)+", height="+height+", width="+width);
                        width++;
                    } else if (height > hist[j]) {
                        max = Math.max(max, height * width);
//                        System.out.println("NEXT is LOW size="+(height * width)+", height="+height+", width="+width+", max is "+max);
                        height=hist[j];
                        width++;
                    } else if (!isFind && height < hist[j]) {
//                        System.out.println("NEXT is HIGH idx="+(j)+" CHANGE, height="+height+", width="+width);
                        idx = j;
                        width++;
                        isFind=true;
                    } else if (isFind && height < hist[j]) {
//                        System.out.println("NEXT is HIGH idx="+(j)+", height="+height+", width="+width);
                        width++;
                    }
                }

                max = Math.max(max, height * width);
//                System.out.println("LAST="+height+"*"+width+"="+(height*width)+", MAX is "+max);
            }

            sb.append(max).append('\n');
        }
        System.out.print(sb.toString());
    }
}

package Test;

import java.util.LinkedList;
import java.util.Queue;

public class LoopEx {
    static boolean[] v2 = new boolean[9];

    public static void loop(int depth) {
        if (depth == 7) {
            for (int i = 0; i < v2.length; i++) {
                if (v2[i]) {
                    System.out.print(i+" ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < v2.length; i++) { // 0 -> 1, 1 -> 1
            if(!v2[i]) {
                v2[i] = true;
                loop(depth+1); // depth+=1,
                v2[i] = false;
            }
        }
    }

    public static int sum(int num1, int num2) {
        return num1+num2;
    }

    public static void main(String[] args) {
        boolean[] v = new boolean[5];
        // f f f f f
        // 0 1 2 3 4

        System.out.println();





        // 0 1 2
        // 0 1 3
        // 0 1 4
        // 0 2 1
        // 0 2 3
        // 0 2 4
        // 0 3 1
        // 0 3 2
        // 0 3 4

        int a = 5;
        for (int i = 0; i < v.length; i++) {
            if (!v[i]) {
                v[i] = true;
                a++;
                for (int i2 = 0; i2 < v.length; i2++) {
                    if (!v[i2]) {
                        v[i2] = true;
                        a++;
                        for (int i3 = 0; i3 < v.length; i3++) {
                            if(!v[i3]) {
                                v[i3] = true;
                                a++;
                                System.out.println(i+" "+i2+" "+i3+" "+a);
                                v[i3] = false;
                                a--;
                            }
                        }
                        v[i2] = false;
                    }
                }
                v[i]=false;
            }
        }

        loop(0);


    }
}

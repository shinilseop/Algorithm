package backjoon._07_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex14_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] dp = new int[s1.length()+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int idx = 0;
        for (int i = 0; i < s1.length(); i++) {
            int idxStand = dp[idx]==-1?0:dp[idx];
            System.out.println(i+" FIND : "+s1.charAt(i));
            System.out.println("ADD PART");

            if (idx == 0) {
                idxStand--;
            }
            for (int j = idxStand+1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (dp[idx] < j) {
                        dp[++idx] = j;

                        System.out.print(idx+" DP:");
                        for (int t = 1; t <= idx; t++) {
                            System.out.printf("%3s", s2.charAt(dp[t]));
                        }
                        System.out.println();
                        System.out.print(idx+" ix:");
                        for (int t = 1; t <= idx; t++) {
                            System.out.printf("%3d", dp[t]);
                        }
                        System.out.println();
                        break;
                    }
                }
            }

            System.out.println("MODIFY "+idxStand);
            for (int j = 0; j < idxStand; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    System.out.println("MODIFY FIND : "+j);
                    for (int k = idx; k>0; k--) {
                        if(dp[k-1] < j) {
                            if(s2.charAt(dp[k]) == s2.charAt(j)){
                                dp[k] = Math.min(dp[k], j);
                            } else {
                                dp[k] = j;
                            }

                            System.out.print(idx+" DP:");
                            for (int t = 1; t <= idx; t++) {
                                System.out.printf("%3s", s2.charAt(dp[t]));
                            }
                            System.out.println();
                            System.out.print(idx+" ix:");
                            for (int t = 1; t <= idx; t++) {
                                System.out.printf("%3d", dp[t]);
                            }
                            System.out.println();

                            break;
                        }
                    }
                }
            }


            System.out.println();
        }
        System.out.println(idx);
    }
}

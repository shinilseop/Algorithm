package new_20251119.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_02798 {
  public static int N, M;
  public static int[] arr;
  public static int answer;
  public static int originDiff;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input1 = br.readLine().split(" ");
    N = Integer.parseInt(input1[0]);
    M = Integer.parseInt(input1[1]);
    answer = -1;
    originDiff = Integer.MAX_VALUE;
    arr = new int[N];

    String[] input2 = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input2[i]);
    }

    for (int i = 0; i < N; i++) {
      addAndCheck(0, i, 0);
    }

    System.out.println(answer);
  }

  public static void addAndCheck(int sum, int idx, int deep) {
    if (deep == 3) {
      return;
    }

    int newSum = sum + arr[idx];
    if (deep == 2 && newSum == M) {
      System.out.println(newSum);
      System.exit(0);
    }

    if (newSum < M) {
      int diff = M - newSum;

      if (deep == 2 && diff < originDiff) {
        answer = newSum;
        originDiff = diff;
      }

      for (int i = 1; i < N; i++) {
        if (idx + i < arr.length) {
          addAndCheck(newSum, idx + i, deep+1);
        }
      }
    }
  }
}

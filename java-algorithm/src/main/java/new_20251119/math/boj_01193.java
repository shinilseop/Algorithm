package new_20251119.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_01193 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());

    int N = 1;
    for (int i = 1; ; ) {
      i += N;
      if (X < i) {
        int first;
        int second;
        int move = X - (i - N);
        if (N % 2 == 0) {
          first = 1 + move;
          second = N - move;
        } else {
          first = N - move;
          second = 1 + move;
        }
        System.out.println(first+"/"+second);
        break;
      }
      N++;
    }
  }
}


/*
1  1/1

2  1/2
3  2/1

4  3/1
5  2/2
6  1/3

7  1/4
8  2/3
9  3/2
10 4/1

11 5/1
12 4/2
13 3/3
14 2/4
15 1/5

16 1/6

시작지점이 1, 2, 4, 7, 11 로 1, 2, 3, 4 씩 등차수열만큼 더 해짐
짝수인경우 1/N, 홀수인 경우 N/1 로 시작
*/

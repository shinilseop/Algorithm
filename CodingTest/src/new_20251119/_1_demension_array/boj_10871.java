package new_20251119._1_demension_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10871 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input1 = br.readLine().split(" ");

    int N = Integer.parseInt(input1[0]);
    int X = Integer.parseInt(input1[1]);

    String[] input2 = br.readLine().split(" ");
    StringBuilder sb = new StringBuilder(N);

    for (int i = 0; i < N; i++) {
      if(X > Integer.parseInt(input2[i])){
        sb.append(input2[i]).append(' ');
      }
    }

    System.out.println(sb.toString().strip());
  }
}

package new_20251119._1_demension_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class boj_05597 {
  public static void main(String[] args) throws IOException {
    HashSet<Integer> set = new LinkedHashSet<>();
    for (int i = 1; i <31; i++) {
      set.add(i);
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 28; i++) {
      int num = Integer.parseInt(br.readLine());
      set.remove(num);
    }

    for (Integer i : set) {
      System.out.println(i);
    }
  }
}

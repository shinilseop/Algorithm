package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Ex10_02 {
    static HashMap<String, Integer> typesIdx;
    static ArrayList<Integer> clothCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(loop * 2);

        while (loop-- > 0) {
            int size = Integer.parseInt(br.readLine());
            if (size == 0) {
                sb.append(0).append('\n');
            } else {
                typesIdx = new HashMap<>();
                clothCnt = new ArrayList<>();
                int idx = 0;

                for (int i = 0; i < size; i++) {
                    String cloth = (br.readLine()).split(" ")[1];
                    if (!typesIdx.containsKey(cloth)) {
                        typesIdx.put(cloth, idx++);
                        clothCnt.add(1);
                    } else {
                        clothCnt.set(typesIdx.get(cloth), clothCnt.get(typesIdx.get(cloth)) + 1);
                    }
                }

                long sum = 1;
                for (int i = 0; i < clothCnt.size(); i++) {
                    sum *= clothCnt.get(i)+1;
                }
                sum--;
                sb.append(sum).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}

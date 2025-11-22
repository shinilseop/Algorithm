package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Ex10_01_timeover {
    static HashMap<String, Integer> clothType = new HashMap<>();
    static ArrayList<String> keys = new ArrayList<>();

    public static long getClothCombination(int loop, int start) {
        if (loop == 0) {
            return 1;
        }

        long sum = 0;
        for (int i = start; i < keys.size(); i++) {
            sum += clothType.get(keys.get(i)) * getClothCombination(loop - 1, i + 1);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(loop * 2);

        while (loop-- > 0) {
            int size = Integer.parseInt(br.readLine());
            if (size == 0) {
                sb.append(0).append('\n');
            } else {
                clothType = new HashMap<>();
                keys = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    String type = (br.readLine()).split(" ")[1];
                    if (clothType.containsKey(type)) {
                        clothType.put(type, clothType.get(type)+1);
                    } else {
                        keys.add(type);
                        clothType.put(type, 1);
                    }
                }

                long sum = 0;
                for (int i = 1; i <= keys.size(); i++) {
                    sum += getClothCombination(i, 0);
                }

                sb.append(sum).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}

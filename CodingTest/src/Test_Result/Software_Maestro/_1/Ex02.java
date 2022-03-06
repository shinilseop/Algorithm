package Test_Result.Software_Maestro._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Ex02 {
    // 메모리 저장 알고리즘
    // 레벨 별 메모리 저장

    static HashMap<Integer, Integer>[] datas;
    static int[] memorySum, memoryMax;
    static int level, cmd;

    public static void avalanche(int from, int to) {
        while (memorySum[from] > memoryMax[from]) {
            Iterator<Integer> fromIter = datas[from].keySet().iterator();
            ArrayList<Integer> removeKey = new ArrayList<>();
            while (fromIter.hasNext()) {
                int key = fromIter.next();
                if (datas[to].containsKey(key)) {
                    memorySum[to] -= datas[to].get(key);
                }
                datas[to].put(key, datas[from].get(key));
                removeKey.add(key);
            }

            for (Integer key : removeKey) {
                datas[from].remove(key);
            }

            memorySum[to] += memorySum[from];
            memorySum[from] = 0;
            from++;
            to++;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        level = Integer.parseInt(st.nextToken());
        cmd = Integer.parseInt(st.nextToken());

        datas = new HashMap[level + 1];
        for (int i = 0; i <= level; i++) {
            datas[i] = new HashMap<>();
        }
        memorySum = new int[level + 1];
        memoryMax = new int[level + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < level; i++) {
            memoryMax[i] = Integer.parseInt(st.nextToken());
        }
        memoryMax[level] = Integer.MAX_VALUE;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if (s.equals("I")) {
                int k = Integer.parseInt(st.nextToken());
                int S = Integer.parseInt(st.nextToken());

                if (datas[1].containsKey(k)) {
                    memorySum[1] -= datas[1].get(k);
                }

                datas[1].put(k, S);
                memorySum[1] += S;
                if (memorySum[1] > memoryMax[1]) {
                    avalanche(1, 2);
                }
            } else {
                int k = Integer.parseInt(st.nextToken());
                boolean find = false;
                for (int j = 1; j <= level; j++) {
                    if (datas[j].containsKey(k)) {
                        sb.append(j).append(' ').append(datas[j].get(k)).append('\n');
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    sb.append("none\n");
                }
            }
        }

        System.out.print(sb.toString().strip());
    }
}

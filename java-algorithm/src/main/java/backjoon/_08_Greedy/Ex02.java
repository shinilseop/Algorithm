package backjoon._08_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex02 {
    public static class Conference implements Comparable<Conference> {
        int startTime, endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }


        @Override
        public int compareTo(Conference o) {
            if(this.endTime == o.endTime){
                return this.startTime - o.startTime;
            }
            return this.endTime - o.endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Conference[] conf = new Conference[size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            conf[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(conf);
//        for (int i = 0; i < size; i++) {
//            System.out.println(conf[i].startTime + " " + conf[i].endTime);
//        }

        int positiveConf = 0;
        int lastTime = 0;
        for (int i = 0; i < size; i++) {
            if (conf[i].startTime >= lastTime) {
                lastTime = conf[i].endTime;
                positiveConf++;
            }
        }

        System.out.println(positiveConf);
    }
}

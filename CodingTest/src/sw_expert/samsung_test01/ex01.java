package sw_expert.samsung_test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex01 {
    static int minDist;
    static boolean[] isFishing;
    static Fishing[] fishing;

    public static void dfs(int dist, int depth) {
        if (depth == fishing.length) {
            minDist = Math.min(dist, minDist);
//            System.out.println("@@@@@@@@@@@@min:" + minDist);
        }

        for (int i = 0; i < fishing.length; i++) {
            if (!fishing[i].isFinish) {
//                if(depth==0) System.out.println("DEPTH :: "+depth);
                fishing[i].isFinish = true;
                boolean[] temp = isFishing.clone();
//                System.out.println("left setting " + i);
                int leftDist = leftPos(i);
                dfs(leftDist + dist, depth + 1);
                isFishing = temp.clone();
//                System.out.println("right setting " + i);
                int rightDist = rightPos(i);
                dfs(rightDist + dist, depth + 1);
                isFishing = temp.clone();
                fishing[i].isFinish = false;
            }
        }
    }

    public static int leftPos(int idx) {
        int dist = 0;
        int left = fishing[idx].pos;
        int right = fishing[idx].pos;
//        System.out.println("INIT >> left :" + left + ", right :" + right);


        for (int i = 0; i < fishing[idx].fisher; i++) {
            while (true) { // 왼쪽 탐색
                if (left == -1 || !isFishing[left]) {
                    break;
                }
                left--;
            }

            while (true) { // 오른쪽 탐색
                if (right == isFishing.length || !isFishing[right]) {
                    break;
                }
                right++;
            }
//            System.out.println("left :" + left + ", right :" + right);

            if (left == -1) {
                dist += right - fishing[idx].pos + 1;
                isFishing[right++] = true;
            } else if (right == isFishing.length) {
                dist += fishing[idx].pos - left + 1;
                isFishing[left--] = true;
            } else {
                int leftDist = fishing[idx].pos - left;
                int rightDist = right - fishing[idx].pos;
                if (leftDist > rightDist) {
                    dist += right - fishing[idx].pos + 1;
                    isFishing[right++] = true;
                } else if (leftDist < rightDist) {
                    dist += fishing[idx].pos - left + 1;
                    isFishing[left--] = true;
                } else { // leftDist == rightDist
                    dist += fishing[idx].pos - left + 1;
                    isFishing[left--] = true;
                }
            }
//            System.out.println(Arrays.toString(isFishing) + ", " + dist);
        }

        return dist;
    }

    public static int rightPos(int idx) {
        int dist = 0;
        int left = fishing[idx].pos;
        int right = fishing[idx].pos;
//        System.out.println("INIT >> left :" + left + ", right :" + right);

        for (int i = 0; i < fishing[idx].fisher; i++) {
            while (true) { // 왼쪽 탐색
                if (left == -1 || !isFishing[left]) {
                    break;
                }
                left--;
            }

            while (true) { // 오른쪽 탐색
                if (right == isFishing.length || !isFishing[right]) {
                    break;
                }
                right++;
            }
//            System.out.println("left :" + left + ", right :" + right);

            if (left == -1) {
                dist += right - fishing[idx].pos + 1;
                isFishing[right++] = true;
            } else if (right == isFishing.length) {
                dist += fishing[idx].pos - left + 1;
                isFishing[left--] = true;
            } else {
                int leftDist = fishing[idx].pos - left;
                int rightDist = right - fishing[idx].pos;
                if (leftDist > rightDist) {
                    dist += right - fishing[idx].pos + 1;
                    isFishing[right++] = true;
                } else if (leftDist < rightDist) {
                    dist += fishing[idx].pos - left + 1;
                    isFishing[left--] = true;
                } else { // leftDist == rightDist
                    dist += right - fishing[idx].pos + 1;
                    isFishing[right++] = true;
                }
            }
//            System.out.println(Arrays.toString(isFishing) + ", " + dist);
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            isFishing = new boolean[N];
            fishing = new Fishing[3];
            minDist = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                fishing[i] = new Fishing(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            }

            dfs(0, 0);

            System.out.println("#"+t+" "+minDist);
        }
    }
}

class Fishing {
    int pos;
    int fisher;
    boolean isFinish;

    public Fishing(int pos, int fisher) {
        this.pos = pos;
        this.fisher = fisher;
        this.isFinish = false;
    }
}


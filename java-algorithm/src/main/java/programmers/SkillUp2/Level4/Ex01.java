package programmers.SkillUp2.Level4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex01 {
    public int solution(int[] cookie) {
        int leftSum = 0, rightSum = 0;
        int left = 0, right = 0;
        int max = 0;

        for (int i = 0; i < cookie.length - 1; i++) {
            left = i;
            leftSum = cookie[left];
            right = i + 1;
            rightSum = cookie[right];
            System.out.println(leftSum+" "+rightSum);

            while (true) {
                if (leftSum == rightSum && max < leftSum) {
                    max = leftSum;
                }
                if (0 < left && leftSum <= rightSum) {
                    left--;
                    leftSum += cookie[left];
                } else if (right < cookie.length-1 && leftSum >= rightSum) {
                    right++;
                    rightSum += cookie[right];
                } else {
                    break;
                }
            }
        }


//        int[] prefix = new int[size + 1];
//        prefix[1] = cookie[0];
//        for (int i = 1; i <= size; i++) {
//            prefix[i] = prefix[i - 1] + cookie[i - 1];
//        }

//        loop:
//        for (int k = 1; k < size; k++) {
//            if(prefix[k] < max)
//                break;
//            for (int i = 0; i < k; i++) {
//                int left = prefix[k] - prefix[i];
//                if(left < max)
//                    break;
//                for (int j = k+1; j <= size; j++) {
//                    int right = prefix[j] - prefix[k];
//                    if (left < right)
//                        break;
//
//                    if (left == right) {
//                        max = Math.max(max, left);
//                        continue loop;
//                    }
//                }
//            }
//        }

        return max;
    }

    public static void main(String[] args) {
        Ex01 main = new Ex01();
        System.out.println(main.solution(new int[]{1, 2, 4, 5}));
    }
}

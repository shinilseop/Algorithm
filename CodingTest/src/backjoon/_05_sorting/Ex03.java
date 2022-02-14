package backjoon._05_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        double sum = 0;
        int[] arr = new int[_loop];
        int[] cntPlus = new int[4001];
        int[] cntMinus = new int[4001];
        for (int i = 0; i < _loop; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            sum+=arr[i];

            if(arr[i] >= 0){
                cntPlus[arr[i]]++;
            } else {
                cntMinus[-arr[i]]++;
            }
        }

        int maxFreqCnt = 0;
        ArrayList<Integer> freqList = new ArrayList<>();
        for (int i = 0; i < cntPlus.length; i++) {
            if (maxFreqCnt < cntPlus[i]) {
                maxFreqCnt = cntPlus[i];
                freqList.clear();
                freqList.add(i);
            } else if (maxFreqCnt == cntPlus[i]) {
                freqList.add(i);
            }
        }

        for (int i = 1; i < cntMinus.length; i++) {
            if (maxFreqCnt < cntMinus[i]) {
                maxFreqCnt = cntMinus[i];
                freqList.clear();
                freqList.add(-i);
            } else if (maxFreqCnt == cntMinus[i]) {
                freqList.add(-i);
            }
        }


        Collections.sort(freqList);
        int maxFreqValue = freqList.size() > 1 ? freqList.get(1) : freqList.get(0);
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        double avg = sum / _loop;
        if(avg < 0){
            avg -= 0.5;
        } else {
            avg += 0.5;
        }
        System.out.println((int)avg);
        System.out.println(arr[_loop/2]);
        System.out.println(maxFreqValue);
        System.out.println(arr[arr.length-1]-arr[0]);
    }
}

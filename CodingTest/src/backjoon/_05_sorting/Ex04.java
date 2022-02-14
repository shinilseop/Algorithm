package backjoon._05_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numStr = (br.readLine()).split("");

        int[] arr = IntStream.range(0, numStr.length).map(i->Integer.parseInt(numStr[i])).toArray();
        Arrays.sort(arr);
        IntStream.range(0, arr.length).map(i->arr[arr.length-1-i]).forEach(System.out::print);
    }
}

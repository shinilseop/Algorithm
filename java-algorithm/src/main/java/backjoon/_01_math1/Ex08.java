package backjoon._01_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger bigInt1 = new BigInteger(st.nextToken());
        BigInteger bigInt2 = new BigInteger(st.nextToken());
        System.out.println(bigInt1.add(bigInt2));
    }
}

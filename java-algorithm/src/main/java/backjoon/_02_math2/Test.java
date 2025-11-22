package backjoon._02_math2;

public class Test {
    public static void main(String[] args) {
        int primeCnt[] = new int[123457*2];
        primeCnt[1] = 0;
        boolean isNormal[] = new boolean[123457*2];
        for (int i = 2; i < isNormal.length; i++) {
            if(!isNormal[i]) {
                primeCnt[i] = primeCnt[i-1]+1;
                for (int j = i + i; j < isNormal.length; j+=i) {
                    isNormal[j] = true;
                }
            } else {
                primeCnt[i] = primeCnt[i-1];
            }
        }

        for (int i = 0; i < 1000; i++) {
            if(!isNormal[i]) {
                System.out.printf("%5d", i);
            }

            if(i%100 == 0){
                System.out.println();
            }
        }
    }
}

package Test_Result.Line;

public class Ex04 {

    public int solution(int[] arr, int[] brr) {
        int answer = 0;

        for (int i = 0; i < arr.length-1; i++) {
            if (brr[i] != arr[i]) {
                System.out.print(i+" change ");
                System.out.print(i+"\t::"+arr[i]+" to "+brr[i]);
                System.out.print(i+"\t::"+arr[i+1]+" to "+(arr[i+1]+(arr[i]-brr[i])));
                answer++;
                arr[i+1]+=(arr[i]-brr[i]);
                arr[i] = brr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex04 main = new Ex04();
//        System.out.println(main.solutions());
//        System.out.println(Arrays.toString(main.solutions()));
    }
}

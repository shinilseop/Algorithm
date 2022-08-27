package sw_expert.samsung_test01;

public class test {
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0]=0;
        nums[1]=1;
        nums[2]=2;

        int[] temp = nums.clone();
        nums[1] = 3;


        System.out.println(temp[1]);
    }
}

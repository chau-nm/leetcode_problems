class Solution {
    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int num : nums){
            min = Math.min(digitSum(num), min);
        }

        return min;
    }

    public static int digitSum(int num){

        int sum = 0;

        while(num > 0){
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }

        return sum;
    }
}
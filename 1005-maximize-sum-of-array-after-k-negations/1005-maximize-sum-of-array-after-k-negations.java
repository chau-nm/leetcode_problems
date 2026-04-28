class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < k; i++) {
            nums[0] *= -1;
            int temp = nums[0];
            int j = 1;
            while (j < nums.length && temp > nums[j]) {
                nums[j - 1] = nums[j];
                j++;
            }
            nums[j - 1] = temp;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
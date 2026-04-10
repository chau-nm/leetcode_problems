class Solution {
    public void sortColors(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = result.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[left] = nums[i];
                left++;
            }
            if (nums[i] == 2) {
                result[right] = nums[i];
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            result[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
class Solution {
    public void moveZeroes(int[] nums) {
        int rightIndex = nums.length - 1;
        int leftIndex = 0;
        while (leftIndex < rightIndex) {
            if (nums[leftIndex] == 0) {
                for (int i = leftIndex + 1; i <= rightIndex; i++) {
                    nums[i - 1] = nums[i];
                }
                nums[rightIndex] = 0;
                rightIndex--;
            }
            if (nums[leftIndex] != 0) {
                leftIndex++;
            }
        }
    }
}
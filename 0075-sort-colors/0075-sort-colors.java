class Solution {
    public void sortColors(int[] nums) {
        int low = 0, middle = 0, high = nums.length - 1;

        while (middle <= high) {
            if (nums[middle] == 2) {
                this.swap(nums, middle, high--);
            }
            if (nums[middle] == 0) {
                this.swap(nums, middle, low++);
            }
            middle++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            min = Math.min(min, Math.abs(nums[i] - nums[i + k - 1]));
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
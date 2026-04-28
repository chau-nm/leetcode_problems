class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int subsum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(nums[i]);
            subsum += nums[i];
            if (subsum > sum - subsum) {
                return result;
            }
        }
        return result;
    }
}
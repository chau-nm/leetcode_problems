class Solution {
    public int minimumDistance(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] == nums[j] && nums[i] == nums[k]) {
                        int dis = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                        min = Math.min(min, dis);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
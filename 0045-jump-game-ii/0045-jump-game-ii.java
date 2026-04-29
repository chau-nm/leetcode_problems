class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int jump = 0;
        int currentEnd = 0;
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentEnd) {
                jump++;
                currentEnd = maxReach;

                if (currentEnd >= nums.length - 1) break;
            }
        }
        return jump;
    }
}
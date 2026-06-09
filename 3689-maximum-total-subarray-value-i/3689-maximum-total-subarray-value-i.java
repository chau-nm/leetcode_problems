class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long mx = 0;
        long mn = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > mx) mx = num;
            if (num < mn) mn = num;
        }

        return (mx - mn) * 1L * k;
    }
}
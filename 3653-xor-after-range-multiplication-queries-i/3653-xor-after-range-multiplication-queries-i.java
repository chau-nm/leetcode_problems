class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];

            while (idx <= queries[i][1]) {
                nums[idx] = (int) ((long) nums[idx] * queries[i][3] % 1_000_000_007);
                idx += queries[i][2];
            }
        }
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
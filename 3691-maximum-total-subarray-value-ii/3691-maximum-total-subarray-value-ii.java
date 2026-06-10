class Solution {
    private int[][] stMax;
    private int[][] stMin;
    private int[] lg;

    private long getValue(int l, int r) {

        int len = r - l + 1;
        int p = lg[len];

        int mx = Math.max(
            stMax[p][l],
            stMax[p][r - (1 << p) + 1]
        );

        int mn = Math.min(
            stMin[p][l],
            stMin[p][r - (1 << p) + 1]
        );

        return (long) mx - mn;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        // Precompute logs
        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int LOG = lg[n] + 1;

        stMax = new int[LOG][n];
        stMin = new int[LOG][n];

        // Level 0
        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        // Build Sparse Tables
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {

                stMax[j][i] = Math.max(
                    stMax[j - 1][i],
                    stMax[j - 1][i + (1 << (j - 1))]
                );

                stMin[j][i] = Math.min(
                    stMin[j - 1][i],
                    stMin[j - 1][i + (1 << (j - 1))]
                );
            }
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(b[0], a[0])
        );

        // Initial candidates
        for (int l = 0; l < n; l++) {
            pq.offer(new long[]{getValue(l, n - 1), l, n - 1});
        }

        long ans = 0;

        while (k-- > 0) {

            long[] cur = pq.poll();

            long val = cur[0];
            int l = (int) cur[1];
            int r = (int) cur[2];

            ans += val;

            if (r > l) {
                pq.offer(new long[]{getValue(l, r - 1),l,r - 1});
            }
        }

        return ans;
    }
}
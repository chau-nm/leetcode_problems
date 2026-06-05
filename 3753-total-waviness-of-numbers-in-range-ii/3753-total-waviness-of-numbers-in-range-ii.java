class Solution {

    static class Node {
        long waviness;
        long cnt;

        Node(long waviness, long cnt) {
            this.waviness = waviness;
            this.cnt = cnt;
        }
    }

    private String s;
    private Node[][][][][] dp;
    private boolean[][][][][] vis;

    private Node dfs(int pos, int tight, int started, int prev2, int prev1) {

        if (pos == s.length()) {
            return new Node(0, 1);
        }

        if (vis[pos][tight][started][prev2][prev1]) {
            return dp[pos][tight][started][prev2][prev1];
        }

        vis[pos][tight][started][prev2][prev1] = true;

        long totalWaviness = 0;
        long totalCnt = 0;

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Node child = dfs(pos + 1, nextTight, 0, 10, 10);

                totalWaviness += child.waviness;
                totalCnt += child.cnt;
            } else {

                int nPrev2;
                int nPrev1;
                long add = 0;

                if (started == 0) {

                    nPrev2 = 10;
                    nPrev1 = d;

                } else {

                    if (prev2 != 10) {

                        boolean peak =(prev1 > prev2 && prev1 > d);
                        boolean valley =(prev1 < prev2 && prev1 < d);

                        if (peak || valley) {
                            add = 1;
                        }
                    }

                    nPrev2 = prev1;
                    nPrev1 = d;
                }

                Node child = dfs(pos + 1,nextTight,1,nPrev2,nPrev1);

                totalWaviness += child.waviness + add * child.cnt;
                totalCnt += child.cnt;
            }
        }

        return dp[pos][tight][started][prev2][prev1] =
                new Node(totalWaviness, totalCnt);
    }

    private long solve(long n) {

        if (n <= 0) {
            return 0;
        }

        s = Long.toString(n);
        dp = new Node[17][2][2][11][11];
        vis = new boolean[17][2][2][11][11];

        return dfs(0, 1, 0, 10, 10).waviness;
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}
class Solution {
    static final int MOD = 1_000_000_007;

    private long power(long a, long b) {
        long ans = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return ans;
    }

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(new int[]{1, 0}); // {node, depth}
        vis[1] = true;

        int maxDepth = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int node = cur[0];
            int depth = cur[1];

            maxDepth = Math.max(maxDepth, depth);

            for (int neighbour : adj.get(node)) {
                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.offer(new int[]{neighbour, depth + 1});
                }
            }
        }

        return (int) power(2, maxDepth - 1);
    }
}
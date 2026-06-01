class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int total = 0;

        int position = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            if (position % 3 != 2) {
                total += cost[i];
            }

            position++;
        }

        return total;
    }
}
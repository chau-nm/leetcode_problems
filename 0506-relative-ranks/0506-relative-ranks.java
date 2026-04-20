class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        String[] medals = new String[]{ "Gold Medal", "Silver Medal", "Bronze Medal" };

        for (int i = 0; i < score.length; i++) {
            pq.add(new int[]{ score[i], i });
        }

        String[] result = new String[score.length];
        int idx = 0;
        while (!pq.isEmpty()) {
            int[] athlete = pq.poll();
            if (idx < 3) {
                result[athlete[1]] = medals[idx];
            } else {
                result[athlete[1]] = String.valueOf(idx + 1);
            }
            idx++;
        }
        return result;
    }
}
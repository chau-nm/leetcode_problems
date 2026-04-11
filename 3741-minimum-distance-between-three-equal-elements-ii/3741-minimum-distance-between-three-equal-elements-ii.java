class Solution {
    public int minimumDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indices: map.values()) {
            if (indices.size() < 3) {
                continue;
            }

            for (int k = 2; k < indices.size(); k++) {
                min = Math.min(min, 2 * (indices.get(k) - indices.get(k - 2)));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
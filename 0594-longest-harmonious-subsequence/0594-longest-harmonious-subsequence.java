class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (Integer num: map.keySet()) {
            if (map.containsKey(num + 1)) {
                result = Math.max(result, map.get(num) + map.get(num + 1));
            }
        }
        return result;
    }
}
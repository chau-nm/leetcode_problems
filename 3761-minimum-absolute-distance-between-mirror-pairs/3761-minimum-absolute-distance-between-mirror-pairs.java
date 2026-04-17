class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                min = Math.min(i - map.get(nums[i]), min);
            }
            map.put(this.reverseNumber(nums[i]), i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int reverseNumber(int num) {
        return Integer.parseInt((new StringBuilder(String.valueOf(num))).reverse().toString());
    }
}
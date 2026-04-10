class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int slow = 0;
        for (int fast = slow; fast < nums.length; fast++) {
            int mapNumber = map.getOrDefault(nums[fast], 0) + 1;
            map.put(nums[fast], mapNumber);

            if (mapNumber <= 2) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }
}
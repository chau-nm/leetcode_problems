
class Solution {

    public boolean check(int[] nums) {

        int drops = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] > nums[i]) {
                drops++;
            }
        }

        if (nums[nums.length - 1] > nums[0]) {
            drops++;
        }

        return drops < 2;
    }
}
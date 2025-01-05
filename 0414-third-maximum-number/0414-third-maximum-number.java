class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        for (Integer num: nums) {
            if (num.equals(first) || num.equals(second) || num.equals(third)) continue;
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }
        return third == null ? first : third;
    }
}
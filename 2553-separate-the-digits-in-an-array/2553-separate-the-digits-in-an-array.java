class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            String numString = String.valueOf(nums[i]);
            for (int j = 0; j < numString.length(); j++) {
                result.add(Integer.parseInt(String.valueOf(numString.charAt(j))));
            }
        }

        
        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
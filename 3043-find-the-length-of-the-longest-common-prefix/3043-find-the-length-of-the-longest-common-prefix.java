class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int commonPrefixLength = 0;
        HashSet<Integer> prefixSet = new HashSet<>();
        for (int num : arr1) {
            while (num > 0) {
                prefixSet.add(num);
                num /= 10;
            }
        }
        for (int num : arr2) {
            while (num > 0) {
                if (prefixSet.contains(num)) {
                    int prefixLength = String.valueOf(num).length();
                    if(prefixLength > commonPrefixLength) {
                        commonPrefixLength = prefixLength;
                    }
                    break;
                }
                num /= 10;
            }
        }
        return commonPrefixLength;
    }
}
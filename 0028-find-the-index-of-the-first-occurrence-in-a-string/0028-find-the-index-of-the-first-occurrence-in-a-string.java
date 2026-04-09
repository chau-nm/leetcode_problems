class Solution {
    public int strStr(String haystack, String needle) {
        for (int left = 0, right = needle.length(); right <= haystack.length(); left++, right++) {
            if (haystack.substring(left, right).equals(needle)) {
                return left;
            }
        }
        return -1;
    }
}
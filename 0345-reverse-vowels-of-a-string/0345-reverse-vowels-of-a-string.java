class Solution {
    public String reverseVowels(String s) {
        char[] sArr = s.toCharArray();
        int left = 0;
        int right = sArr.length - 1;
        while (left < right) {
            while (left < right && !isVowel(sArr[left])) {
                left++;
            }
            while (left < right && !isVowel(sArr[right])) {
                right--;
            }
            if (left < right) {
                char temp = sArr[left];
                sArr[left] = sArr[right];
                sArr[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(sArr);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
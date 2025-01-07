class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            concat.append(words[i]);
            if (String.valueOf(concat).equals(s)) {
                return true;
            }
        }
        return false;
    }
}
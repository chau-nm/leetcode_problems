class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            if (map1.containsKey(word2.charAt(i))) {
                map1.put(word2.charAt(i), map1.get(word2.charAt(i)) - 1);
            } else {
                map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
            }
        }
        for (Character ch: map1.keySet()) {
            Integer count = map1.get(ch);
            if (count < -3 || count > 3) {
                return false;
            }
        }
        for (Character ch: map2.keySet()) {
            Integer count = map2.get(ch);
            if (count > 3) {
                return false;
            }
        }
        return true;
    }
}
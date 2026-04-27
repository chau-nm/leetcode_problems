class Solution {
    public boolean judgeCircle(String moves) {
        if ((moves.length() & 1) == 1) return false;

        int x = 0, y = 0;

        Map<Character, int[]> dir = new HashMap<>();
        dir.put('U', new int[] {0, 1});
        dir.put('D', new int[] {0, -1});
        dir.put('L', new int[] {-1, 0});
        dir.put('R', new int[] {1, 0});

        for (int i = 0; i < moves.length(); i++) {
            int[] d = dir.get(moves.charAt(i));
            x += d[0];
            y += d[1];
        }

        return x == 0 && y == 0;
    }
}
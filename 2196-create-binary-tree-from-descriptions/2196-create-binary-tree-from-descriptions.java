class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> mp = new HashMap<>();
        Set<Integer> hasParent = new HashSet<>();
        
        for (int i = 0; i < descriptions.length; i++) {
            if (!mp.containsKey(descriptions[i][0]))
                mp.put(descriptions[i][0], new TreeNode(descriptions[i][0]));
            if (!mp.containsKey(descriptions[i][1]))
                mp.put(descriptions[i][1], new TreeNode(descriptions[i][1]));
            hasParent.add(descriptions[i][1]);
        }
        
        TreeNode root = null;
        for (int i = 0; i < descriptions.length; i++) {
            if (descriptions[i][2] == 1) { // left
                mp.get(descriptions[i][0]).left = mp.get(descriptions[i][1]);
            } else { // right
                mp.get(descriptions[i][0]).right = mp.get(descriptions[i][1]);
            }
            if (!hasParent.contains(descriptions[i][0])) {
                root = mp.get(descriptions[i][0]);
            }
        }
        return root;
    }
}
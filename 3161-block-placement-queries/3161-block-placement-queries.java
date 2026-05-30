class Solution {
    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        set.add(0);
        set.add(Integer.MAX_VALUE);
        map.put(Integer.MAX_VALUE, new TreeSet<>());
        map.get(Integer.MAX_VALUE).add(0);
        for (int[] q : queries) {
            if (q[0] == 1) {
                int v1 = set.lower(q[1]);
                int v2 = set.higher(q[1]);
                int si = v2 - v1;
                map.get(si).remove(v1);
                if (map.get(si).isEmpty())
                    map.remove(si);
                if (!map.containsKey(q[1] - v1))
                    map.put(q[1] - v1, new TreeSet<>());
                if (!map.containsKey(v2 - q[1]))
                    map.put(v2 - q[1], new TreeSet<>());
                map.get(q[1] - v1).add(v1);
                map.get(v2 - q[1]).add(q[1]);
                set.add(q[1]);
            } else {
                int x = q[1];
                int sz = q[2];
                boolean f = false;
                for (int e : map.keySet()) {
                    if (e < sz)
                        break;
                    TreeSet<Integer> s = map.get(e);
                    Integer ele = s.floor(x - sz);
                    if (ele != null) {
                        f = true;
                        break;
                    }
                }
                ans.add(f);
            }
        }
        return ans;
    }
}
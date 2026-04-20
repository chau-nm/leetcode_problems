class Solution {
    class Pair {
        int soldiers;
        int idx;

        public Pair(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                return a.soldiers == b.soldiers ? a.idx - b.idx : a.soldiers - b.soldiers;
            }
        );

        for (int row = 0; row < mat.length; row++) {
            int count = 0;
            for (int col: mat[row]) {
                if (col == 1) {
                    count++;
                }
            }
            pq.add(new Pair(count, row));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().idx;
        }
        return result;
    }
}
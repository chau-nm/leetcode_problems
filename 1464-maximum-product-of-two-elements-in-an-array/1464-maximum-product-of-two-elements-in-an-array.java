class Solution {
    public int maxProduct(int[] nums) {
        int k = 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        for (int num: nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return (pq.poll() - 1) * (pq.poll() - 1);
    }
}
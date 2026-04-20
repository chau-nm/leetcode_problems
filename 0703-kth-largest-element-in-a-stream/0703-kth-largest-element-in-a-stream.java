class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {
        this.minHeap.add(val);
        if (minHeap.size() > k) {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
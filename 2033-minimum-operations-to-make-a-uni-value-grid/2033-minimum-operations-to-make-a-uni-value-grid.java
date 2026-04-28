class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> arr = new ArrayList<>();

        for(int[] row : grid){
            for(int v : row){
                arr.add(v);
            }
        }

        int base = arr.get(0);
        for(int v : arr){
            if(Math.abs(v - base) % x != 0)
                return -1;
        }

        Collections.sort(arr);

        int median = arr.get(arr.size()/2);

        int ops = 0;
        for(int v : arr){
            ops += Math.abs(v - median) / x;
        }

        return ops;
    }
}
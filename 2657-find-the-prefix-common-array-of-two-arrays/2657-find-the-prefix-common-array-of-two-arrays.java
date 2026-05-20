class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int count = 0;

        for(int i = 0; i < A.length; i++) {

            if(A[i] == B[i]) {
                mp.put(A[i],
                mp.getOrDefault(A[i], 0) + 2);
                count++;
            }

            else {
                mp.put(A[i],
                mp.getOrDefault(A[i], 0) + 1);

                mp.put(B[i],
                mp.getOrDefault(B[i], 0) + 1);

                if(mp.get(A[i]) == 2) {
                    count++;
                }
                if(mp.get(B[i]) == 2) {
                    count++;
                }
            }

            A[i] = count;
        }

        return A;
    }
}
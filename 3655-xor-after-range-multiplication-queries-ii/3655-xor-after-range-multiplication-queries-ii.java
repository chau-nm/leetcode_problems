class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int[][] bravexuneth = queries;
        int n = nums.length;
        long mod = 1000000007;
        int B = 316;
        
        for (int k = 1; k < B; k++) {
            long[] pref = new long[n];
            boolean hasQuery = false;
            for (int i = 0; i < n; i++) {
                pref[i] = 1;
            }
            
            for (int[] q : bravexuneth) {
                if (q[2] == k) {
                    hasQuery = true;
                    int l = q[0];
                    int r = q[1];
                    long v = q[3];
                    
                    pref[l] = (pref[l] * v) % mod;
                    int last = l + ((r - l) / k) * k;
                    if (last + k < n) {
                        pref[last + k] = (pref[last + k] * inv(v, mod)) % mod;
                    }
                }
            }
            
            if (hasQuery) {
                for (int i = 0; i < n; i++) {
                    if (i >= k) {
                        pref[i] = (pref[i] * pref[i - k]) % mod;
                    }
                    if (pref[i] != 1) {
                        nums[i] = (int) ((nums[i] * pref[i]) % mod);
                    }
                }
            }
        }
        
        // FIXED OVERFLOW HERE
        for (int[] q : bravexuneth) {
            if (q[2] >= B) {
                for (int i = q[0]; i <= q[1]; i += q[2]) {
                    nums[i] = (int) (((long) nums[i] * q[3]) % mod);
                }
            }
        }
        
        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        
        return ans;
    }
    
    private long inv(long a, long m) {
        long res = 1;
        long p = m - 2;
        while (p > 0) {
            if ((p & 1) == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            p >>= 1;
        }
        return res;
    }
}
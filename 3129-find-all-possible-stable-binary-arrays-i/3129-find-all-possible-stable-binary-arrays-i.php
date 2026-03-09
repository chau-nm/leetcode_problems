class Solution {

    private $MOD = 1000000007;
    
    /**
     * @param Integer $zero
     * @param Integer $one
     * @param Integer $limit
     * @return Integer
     */
    function numberOfStableArrays($zero, $one, $limit) {
        $dp = array_fill(0, $zero + 1, array_fill(0, $one + 1, [0, 0]));
        $dp[0][0] = [1, 1];
        
        for ($i = 0; $i <= $zero; $i++) {
            for ($j = 0; $j <= $one; $j++) {
                if ($i == 0 && $j == 0) continue;
                
                if ($i > 0) {
                    $sum = 0;
                    for ($k = 1; $k <= min($i, $limit); $k++) {
                        $sum = ($sum + $dp[$i - $k][$j][1]) % $this->MOD;
                    }
                    $dp[$i][$j][0] = $sum;
                }
                
                if ($j > 0) {
                    $sum = 0;
                    for ($k = 1; $k <= min($j, $limit); $k++) {
                        $sum = ($sum + $dp[$i][$j - $k][0]) % $this->MOD;
                    }
                    $dp[$i][$j][1] = $sum;
                }
            }
        }
        
        return ($dp[$zero][$one][0] + $dp[$zero][$one][1]) % $this->MOD;
    }
}
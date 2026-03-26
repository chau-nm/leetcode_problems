class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s) {
        $map = [];
        $maxLength = 0;
        $left = 0;
        $n = strlen($s);

        for ($right = 0; $right < $n; $right++) {
            $char = $s[$right];

            if (isset($map[$char]) && $map[$char] >= $left) {
                $left = $map[$char] + 1;
            }
            $map[$char] = $right;
            $maxLength = max($maxLength, $right - $left + 1);
        }
        return $maxLength;
    }
}
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s) {
        $map = [];
        $left = 0;
        $maxLength = 0;

        for ($right = 0; $right < strlen($s); $right++) {
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
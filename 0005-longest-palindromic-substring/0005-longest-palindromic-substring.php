class Solution {

    /**
     * @param String $s
     * @return String
     */
    function longestPalindrome($s) {
        $result = "";
        for ($i = 0; $i < strlen($s); $i++) {
            $odd = $this->expand($s, $i, $i);
            $even = $this->expand($s, $i, $i + 1);
            $palindrome = strlen($odd) > strlen($even) ? $odd : $even;
            if (strlen($palindrome) > strlen($result)) {
                $result = $palindrome;
            } 
        }
        return $result;
    }

    function expand($s, $left, $right) {
        while (
            $left >=0 &&
            $right < strlen($s) &&
            $s[$left] === $s[$right]
        ) {
            $left--;
            $right++;
        }
        return substr($s, $left + 1, $right - 1);
    }
}
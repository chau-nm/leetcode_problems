class Solution {

    /**
     * @param Integer $x
     * @return Boolean
     */
    function isPalindrome($x) {
        $numString = (string) $x;
        return strrev($numString) == $numString;
    }
}
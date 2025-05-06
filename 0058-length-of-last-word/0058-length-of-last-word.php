class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLastWord($s) {
        $words = preg_split('/\s+/', trim($s));
        return strlen($words[count($words) - 1]);
    }
}
class Solution {

    /**
     * @param String[] $strs
     * @return String
     */
    function longestCommonPrefix($strs) {
        if (count($strs) === 0) {
            return "";
        }
        $preffix = $strs[0];
        for ($i = 1; $i < count($strs); $i++) {
            while (!str_contains($strs[$i], $preffix)) {
                $preffix = substr($preffix, 0, strlen($preffix) - 1);
                if ($preffix === "") {
                    return $preffix;
                }
            }
        }
        return $preffix;
    }
}
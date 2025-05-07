class Solution {

    /**
     * @param String[] $words1
     * @param String[] $words2
     * @return Integer
     */
    function countWords($words1, $words2) {
        return count(array_intersect(
            array_keys(array_filter(array_count_values($words1), function($w) {return $w === 1;})),
            array_keys(array_filter(array_count_values($words2), function($w) {return $w === 1;}))
            )
        );
    }
}
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(array &$nums): int 
    {
        $nums = array_values(array_unique($nums));
        sort($nums);
        return count($nums);
    }
}
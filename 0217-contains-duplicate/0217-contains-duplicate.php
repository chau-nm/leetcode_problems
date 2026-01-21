class Solution {

    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    function containsDuplicate($nums) {
        $map = [];

        for ($i =0; $i < count($nums); $i++) {
            if (isset($map[$nums[$i]])) {
                return true;
            }
            $map[$nums[$i]] = true;
        }

        return false;
    }
}
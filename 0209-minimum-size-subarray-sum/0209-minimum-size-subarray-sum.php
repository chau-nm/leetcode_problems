class Solution {

    /**
     * @param Integer $target
     * @param Integer[] $nums
     * @return Integer
     */
    function minSubArrayLen($target, $nums) {
        $sum = 0; $left = 0; $minLength = count($nums) + 1;

        for ($right = 0; $right < count($nums); $right++) {
            $sum += $nums[$right];

            while ($sum >= $target) {
                $minLength = min($minLength, $right - $left + 1);
                $sum -= $nums[$left];
                $left++;
            }
        }

        return $minLength === count($nums) + 1 ? 0 : $minLength;
    }
}
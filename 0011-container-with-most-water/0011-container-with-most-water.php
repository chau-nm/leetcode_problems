class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function maxArea($height) {
        $left = 0;
        $right = count($height) - 1;
        $maxArea = 0;

        while ($left < $right) {
            $leftHeight = $height[$left];
            $rightHeight = $height[$right];

            $area = ($right - $left) * min($leftHeight, $rightHeight);
            $maxArea = max($maxArea, $area);

            if ($leftHeight < $rightHeight) {
                $left++;
            } else {
                $right--;
            }
        }

        return $maxArea;
    }
}
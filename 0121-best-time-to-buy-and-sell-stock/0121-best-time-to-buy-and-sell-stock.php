class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        $left = 0;
        $max = 0;

        for ($right = 0; $right < count($prices); $right++) {
            if ($prices[$right] < $prices[$left]) {
                $left = $right;
            }
            $max = max($prices[$right] - $prices[$left], $max);
        }

        return $max;
    }
}
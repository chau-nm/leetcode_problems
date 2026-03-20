class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        $len = count($prices);
        $left = 0;
        $max = 0;

        for ($right = 0; $right < $len; $right++) {
            if ($prices[$right] < $prices[$left]) {
                $left = $right;
            } else {
                $max = max($prices[$right] - $prices[$left], $max);
            }
        }

        return $max;
    }
}
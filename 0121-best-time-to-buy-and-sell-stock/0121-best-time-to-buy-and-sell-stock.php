class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        $len = count($prices);
        $min = $prices[0];
        $max = 0;

        foreach ($prices as $price) {
            if ($price < $min) {
                $min = $price;
            } else {
                $max = max($price - $min, $max);
            }
        }

        return $max;
    }
}
class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        $minPrice = PHP_INT_MAX;
        $maxProfit = 0;

        foreach ($prices as $price) {
            $minPrice = min($minPrice, $price);
            $maxProfit = max($maxProfit, $price - $minPrice);
        }

        return $maxProfit;
    }
}
class Solution {

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    function plusOne($digits) {
        $carry = 1;
        $result = [];

        for ($i = count($digits) - 1; $i >= 0; $i--) {
            $sum = $digits[$i] + $carry;
            $result[] = $sum % 10;      
            $carry = intdiv($sum, 10);   
        }

        if ($carry > 0) {
            $result[] = $carry;
        }

        return array_reverse($result);
    }
}
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function romanToInt(string $s): int 
    {
        $symbol = [
            "I" => 1,
            "V" => 5,
            "X" => 10,
            "L" => 50,
            "C" => 100,
            "D" => 500,
            "M" => 1000
        ];

        $total = 0;
        $prev = 0;

        for ($i = strlen($s) - 1; $i >= 0; $i--) {
            $current = $symbol[$s[$i]];

            if ($current < $prev) {
                $total -= $current;
            } else {
                $total += $current;
            }

            $prev = $current;
        }

        return $total;
    }
}
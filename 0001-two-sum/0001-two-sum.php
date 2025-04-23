class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum(array $nums, int $target): array 
    {
        for ($i = 0; $i < count($nums); $i++) {
            $firstNumber = $nums[$i];
            $secondNumber = $target - $firstNumber;
            for ($j = 0; $j < count($nums); $j++) {
                if ($j === $i) {
                    continue;
                }
                if ($nums[$j] === $secondNumber) {
                    return [$i, $j];
                }
            }
        }
        return [];
    }
}
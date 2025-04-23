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
            if (($index = array_search($secondNumber, $nums)) !== null && $index !== $i) {
                return [$i, $index];
            }
        }
        return [];
    }
}
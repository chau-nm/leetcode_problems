class Solution {

    /**
     * @param String $word
     * @return Integer
     */
    function countVowelSubstrings($word) {
        $vowels = ['a', 'e', 'i', 'o', 'u'];
        sort($vowels);
        $wordArr = str_split($word);
        $len = count($wordArr);
        $sumSub = 0;
        $i = -1;
        $counter = 5;

        while($i < $len - 5) {
            $i++;
            $current = array_unique(array_slice($wordArr, $i, $counter));
            sort($current);
            
            if(in_array($wordArr[$counter + $i - 1], $vowels)) {
                $counter++;
                $i--; 
                if($current == $vowels && isset($wordArr[$counter + $i - 1])) {
                    $sumSub++;
                }
            } else {
                $counter = 5;
            }
        }

        return $sumSub;
    }
}
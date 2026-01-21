class Solution {

    /**
     * @param Integer $columnNumber
     * @return String
     */
    function convertToTitle($columnNumber) {
         $title = '';
        
        while ($columnNumber > 0) {
            $columnNumber--;
            $title = chr($columnNumber % 26 + 65) . $title;
            $columnNumber = intval($columnNumber / 26);
        }
        
        return $title;
    }
}
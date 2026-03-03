class Solution {

    /**
     * @param Integer $n
     * @param Integer $k
     * @return String
     */
    function findKthBit($n, $k) {
        $s1 = "0";

        while ($n != 0) {
            $n--;
            $temp = "";
            $del = $this->invert($s1);
            $del = $this->reverse($del);
            $temp .= $s1 . "1" . $del;
            $s1 = $temp;
        }

        return $s1[$k - 1];
    }

    function invert($s) {
        for ($i = 0; $i < strlen($s); $i++) {
            if ($s[$i] == '0') {
                $s[$i] = '1';
            } else {
                $s[$i] = '0';
            }
        }
        return $s;
    }

    function reverse($s) {
        return strrev($s);
    }
}
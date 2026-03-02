class Solution {

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minSwaps($grid) {
        $totalStep = 0;
        
        for ($i = 0; $i < count($grid); $i++) {
            $validRow = $this->findValidRow($grid, $i);
            if ($i === $validRow) {
                continue;
            } 
            if ($validRow === -1) {
                return -1;
            }

            $totalStep += $this->swapFromIndexToTarget($grid, $validRow, $i);
        }

        return $totalStep;
    }

    function findValidRow($grid, $index)
    {
        for ($i = $index; $i < count($grid); $i++) {
            if ($this->isValidRow($grid, $i, $index)) {
                return $i;
            }
        }
        return -1;
    }

    function isValidRow($grid, $rindex, $rTargetIndex) {
        $row = $grid[$rindex];
        $n = count($row);
        $zerosNumberIndex = $n - $rTargetIndex - 1;

        for ($i = $n - 1; $i >= $n - $zerosNumberIndex; $i--) {
            if ($row[$i] !== 0) {
                return false;
            }
        }
        return true;
    }

    function swapFromIndexToTarget(&$grid, $rIndex, $rTarget) {
        $currentRow = $rIndex;
        $step = 0;

        while ($currentRow !== $rTarget) {
            $this->swap($grid, $currentRow, $currentRow - 1);
            $currentRow--;
            $step++;
        }
        return $step;
    }

    function swap(&$grid, $ri, $rj) {
        $rt = $grid[$ri];
        $grid[$ri] = $grid[$rj];
        $grid[$rj] = $rt;
    }
}
import (
    "math"
)

func minEatingSpeed(piles []int, h int) int {
    canEat := func(k int) bool {
        totalHours := 0
        for _, pile := range piles {
            totalHours += int(math.Ceil(float64(pile) / float64(k)))
        }
        return totalHours <= h
    }
    
    low, high := 1, 0
    for _, pile := range piles {
        high = max(pile, high)
    }

    for low < high {
        middle := (low + high) / 2

        if canEat(middle) {
            high = middle
        } else {
            low = middle + 1
        }
    }

    return low
}
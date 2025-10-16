func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    if len(nums1) > len(nums2) {
        return findMedianSortedArrays(nums2, nums1)
    }

    m, n := len(nums1), len(nums2)
    total := m + n
    half := (total + 1)/ 2

    left, right := 0, m

    for left <= right {
        i := (left + right) / 2
        j := half - i

        var Aleft, Aright, Bleft, Bright int

        if i == 0 {
            Aleft = -1 << 31
        } else {
            Aleft = nums1[i-1]
        }

        if i == m {
            Aright = 1<<31 - 1
        } else {
            Aright = nums1[i]
        }

        if j == 0 {
            Bleft = -1 << 31
        } else {
            Bleft = nums2[j-1]
        }

        if j == n {
            Bright = 1<<31 - 1
        } else {
            Bright = nums2[j]
        }

        if Aleft <= Bright && Bleft <= Aright {
            if total % 2 == 0 {
                leftMax := max(Aleft, Bleft)
                rightMin := min(Aright, Bright)
                return float64(leftMax+rightMin) / 2.0
            }

            return float64(max(Aleft, Bleft))
        } else if Aleft > Bright {
            right = i - 1
        } else {
            left = i + 1
        }
    }

    return 0
}
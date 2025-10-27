func numberOfBeams(bank []string) int {
    count:=0
    preLaserNumber := 0
    for i:=0; i < len(bank); i++ {
        currentLaserNumber:=0
        for _, ch := range bank[i] {
            if ch == '1' {
                currentLaserNumber++
            }
        }
        if currentLaserNumber > 0 {
            count += preLaserNumber * currentLaserNumber 
            preLaserNumber = currentLaserNumber
        }
    }
    return count
}
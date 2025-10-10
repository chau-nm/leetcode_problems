func carFleet(target int, position []int, speed []int) int {
    n := len(position)
    cars := make([][2]float64, n)
    for i := 0; i < n; i++ {
        cars[i][0] = float64(position[i])
        cars[i][1] = float64(target - position[i]) / float64(speed[i]) 
    }

    sort.Slice(cars, func(i, j int) bool {
        return cars[i][0] > cars[j][0]
    })

    fleets := 0
    maxTime := 0.0
    for _, car := range cars {
        t := car[1]
        if t > maxTime {
            fleets++
            maxTime = t
        }
    }
    return fleets
}
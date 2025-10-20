func numWaterBottles(numBottles int, numExchange int) int {
    drinkBottles := 0
    waterBottles := numBottles
    for waterBottles >= numExchange {
        drinkBottles += waterBottles / numExchange
        waterBottles = waterBottles / numExchange + waterBottles % numExchange
    }

    return drinkBottles + numBottles
}
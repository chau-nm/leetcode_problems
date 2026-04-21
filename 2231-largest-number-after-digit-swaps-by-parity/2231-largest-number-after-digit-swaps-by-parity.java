class Solution {
    public int largestInteger(int num) {
        int currentNum = num;
        PriorityQueue<Integer> oddPq = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> evenPq = new PriorityQueue<>((a, b) -> (b - a));

        while (currentNum > 0) {
            int digit = currentNum % 10;
            if (digit % 2 == 0) {
                evenPq.add(digit);
            } else {
                oddPq.add(digit);
            }
            currentNum /= 10;
        }

        String numString = String.valueOf(num);
        int result = 0;
        for (int i = 0; i < numString.length(); i++) {
            int digit = numString.charAt(i) - '0';

            int newDigit;
            if (digit % 2 == 0) {
                newDigit = evenPq.poll();
            } else {
                newDigit = oddPq.poll();
            }

            result = result * 10 + newDigit;
        }
        return result;
    }
}
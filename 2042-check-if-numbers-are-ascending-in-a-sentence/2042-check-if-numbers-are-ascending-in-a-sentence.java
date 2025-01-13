class Solution {
    public boolean areNumbersAscending(String s) {
        String[] sArr = s.split(" ");
        int currentNumber = -1;
        for (int i = 0; i < sArr.length; i++) {
            if (isNumeric(sArr[i])) {
                int number = Integer.parseInt(sArr[i]);
                if (number <= currentNumber) {
                    return false;
                } else {
                    currentNumber = number;
                }
            }
        }
        return true;
    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
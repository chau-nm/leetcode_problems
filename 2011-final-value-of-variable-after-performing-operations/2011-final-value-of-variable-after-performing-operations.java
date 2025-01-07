class Solution {
    public int finalValueAfterOperations(String[] operations) {
        Map<String, Integer> operationsMap = new HashMap<>();
        operationsMap.put("--X", -1);
        operationsMap.put("X--", -1);
        operationsMap.put("++X", 1);
        operationsMap.put("X++", 1);
        int x = 0;
        for (String operation : operations) {
            Integer value = operationsMap.get(operation);
            if (value != null) {
                x += value;
            }
        }
        return x;
    }
}
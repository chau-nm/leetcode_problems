class Solution {

    private int calFinishTime(int[] ls, int[] ld,
                              int[] ws, int[] wd) {

        int mini = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < ls.length; i++) {
            mini = Math.min(mini, ls[i] + ld[i]);
        }

        for (int i = 0; i < ws.length; i++) {
            int finish = Math.max(mini, ws[i]) + wd[i];
            ans = Math.min(ans, finish);
        }

        return ans;
    }

    public int earliestFinishTime(int[] landStartTime,
                                  int[] landDuration,
                                  int[] waterStartTime,
                                  int[] waterDuration) {

        int landFirst = calFinishTime(
            landStartTime, landDuration,
            waterStartTime, waterDuration
        );

        int waterFirst = calFinishTime(
            waterStartTime, waterDuration,
            landStartTime, landDuration
        );

        return Math.min(landFirst, waterFirst);
    }
}
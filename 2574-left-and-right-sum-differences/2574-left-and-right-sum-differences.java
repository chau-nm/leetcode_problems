class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[]leftSum=calLeftSum(nums);
        int[]rightSum=calRightSum(nums);
        for(int i=0;i<nums.length;i++){
            leftSum[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return leftSum;
    }
    public static int []calLeftSum(int[]arr){
        int[]ans=new int[arr.length];
        for(int i=1;i<arr.length;i++){
            ans[i]=arr[i-1]+ans[i-1];
        }
        return ans;
    }
    public static int[]calRightSum(int[]arr){
        int n=arr.length;
        int[]ans=new int[n];
        for(int i=n-2;n>=0;i--){
            if(i==-1)break;;
            ans[i]=ans[i+1]+arr[i+1];
        }
        return ans;
    }
}
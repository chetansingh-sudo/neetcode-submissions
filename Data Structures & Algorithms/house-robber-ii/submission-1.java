class Solution {
    public int robbing(int i,int j,int[] arr)
    {
        int[] temp=new int[j-i+1];
        int val=0;
        for(int k=i;k<j;k++)
        {
            temp[val++]=arr[k];
        }
        int[] dp=new int[temp.length];
        dp[0]=temp[0];
        dp[1]=Math.max(temp[0],temp[1]);
        for(int k=2;k<temp.length;k++)
        {
            dp[k]=Math.max(temp[k]+dp[k-2],dp[k-1]);


        }
        return dp[dp.length-1];
    }
    public int rob(int[] nums) {
        if(nums.length==0)
        return 0;
        if(nums.length==1)
        return nums[0];
        return Math.max(robbing(0,nums.length-1,nums),robbing(1,nums.length,nums));
    }
}

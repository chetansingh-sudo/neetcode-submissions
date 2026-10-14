class Solution {
    public int jump(int[] nums) {
        if(nums.length==0 || nums.length==1)
        return 0;
        int coverage=0;
        int lastIndex=0;
        int time=0;
        for(int i=0;i<nums.length;i++)
        {
             coverage=Math.max(coverage,i+nums[i]);
             if(i==lastIndex)
             {
                time++;
                lastIndex=coverage;
                if(coverage>=nums.length-1)
                return time;
             }
        }
        return time;
    }
}

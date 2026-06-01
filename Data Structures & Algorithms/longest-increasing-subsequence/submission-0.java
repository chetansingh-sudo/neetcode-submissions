class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] temp=new int[nums.length];
        Arrays.fill(temp,1);
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    temp[i]=Math.max(temp[i],temp[j]+1);
                }
            }
        }
        int max=0;
        for(int i=0;i<temp.length;i++)
        {
            max=Math.max(max,temp[i]);
        }
        return max;
    }
}

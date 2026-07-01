class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int val=Arrays.stream(nums).sum();
        if(target>val)
        return 0;
        
        int j=0;int i=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(j<nums.length)
        {
            sum+=nums[j];
            while(sum>=target)
            {
               // System.out.println(sum);
                min=Math.min(min,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        if(min==Integer.MAX_VALUE)
        return 0;
        return min;
    }
}
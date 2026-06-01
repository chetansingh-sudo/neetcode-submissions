
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sumTotal=Arrays.stream(nums).boxed().reduce(0,(a,b)->a+b);
        if(target>sumTotal)
        return 0;
        int sum=0;
        int min=(int)(1e9);
        while(j<nums.length)
        {
            
            if(sum<target)
            {
                sum+=nums[j];
                //if(sum<target)
                j++;
            }
            while(sum>=target) 
            {
                
                min=Math.min(min,j-i);
                System.out.println(min+" "+sum+" "+i+" "+j);
                sum-=nums[i];
                i++;
            }
        }
        while(sum>=target)
        {
            min=Math.min(min,j-i);
            sum-=nums[i];
            i++;
        }
        return min;
    }
}
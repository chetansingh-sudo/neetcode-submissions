class Solution {
    public boolean canJump(int[] nums) {
        int max=nums[0];
        for(int i=0;i<nums.length;i++)
        {
              if(max< i)
            return false;
            max=Math.max(max,nums[i]+i);
          
            
        }
        return true;
    }
}

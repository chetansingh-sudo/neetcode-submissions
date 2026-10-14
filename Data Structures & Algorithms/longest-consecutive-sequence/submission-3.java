class Solution {
    public int longestConsecutive(int[] nums) {
      int n=nums.length;
       HashMap<Integer,Boolean> hm=new HashMap<>();
       
       for(int i=0;i<nums.length;i++)
       {
        
        hm.put(nums[i],false);
       }
       int max=0;
       for(int i=0;i<nums.length;i++)
       {
          int left=nums[i]-1;
          int right=nums[i]+1;
          int count=1;
          while(hm.containsKey(left) &&  hm.get(left)==false)
          {
            count++;
              hm.put(left,true);
            left--;
          
          }
          while(hm.containsKey(right) &&  hm.get(right)==false)
          {
            count++;
            hm.put(right,true);
            right++;
            
          }
          max=Math.max(count,max);
       } 
       return max;
    }
}

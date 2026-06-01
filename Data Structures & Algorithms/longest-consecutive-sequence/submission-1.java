class Solution {
    public int longestConsecutive(int[] nums) {
      int max=0;
      HashMap<Integer,Boolean> hm=new HashMap<>();
      for(int i=0;i<nums.length;i++)
      {
        hm.put(nums[i],false);
      }  
      for(int i=0;i<nums.length;i++)
      {
        int curr=1;
        hm.put(nums[i],true);
        int next=nums[i]+1;
        while(hm.containsKey(next) && hm.get(next)==false)
        {
            curr++;
            hm.put(next,true);
            next++;
        }
        int prev=nums[i]-1;
        while(hm.containsKey(prev) && hm.get(prev)==false)
        {
            curr++;
            hm.put(prev,true);
            prev--;
        }
        max=Math.max(max,curr);
      }
      return max;
    }
}

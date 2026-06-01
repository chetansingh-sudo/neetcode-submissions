class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
          hm.put(nums[i],false);
        }
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
          int left=nums[i]-1;
          int curr=1;
          while(hm.containsKey(left) && hm.get(left)==false)
          {
            hm.put(left,true);
            left--;
            curr++;
          }
          int right=nums[i]+1;
          while(hm.containsKey(right) && hm.get(right)==false)
          {
            hm.put(right,true);
            right++;
            curr++;
          }
          max=Math.max(curr,max);
        }
        return max;
    }
}

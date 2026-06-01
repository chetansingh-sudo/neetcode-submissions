class Solution {
  List<List<Integer>> v=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<Integer> t=new ArrayList<>();
        getCombination(0,nums,target,t);
        return v;
    }
    public void getCombination(int ind,int[] nums,int target,List<Integer> t)
    {
      
        if(target==0)
        {
          v.add(new ArrayList(t));
          return ;
        }
      
      for(int i=ind;i<nums.length;i++)
      {
        if(i>ind && nums[i]==nums[i-1])continue;
        if(nums[i]>target)break;
        t.add(nums[i]);
        getCombination(i+1,nums,target-nums[i],t);
        if(t.size()!=0)
        t.remove(t.size()-1);
      }

    }
}
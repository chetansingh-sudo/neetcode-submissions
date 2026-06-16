class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      dfs(nums,0,new ArrayList<>());  
      return ans;
    }
    public void dfs(int[] nums,int ind,List<Integer> temp)
    {
        if(ind==nums.length)
        {
            if(!ans.contains(temp))
            {
                ans.add(new ArrayList<>(temp));
                return;
            }
        }
        if(ind<nums.length){
        List<Integer> op1=new ArrayList<>(temp);
        op1.add(nums[ind]);
        dfs(nums,ind+1,op1);
        dfs(nums,ind+1,temp);
        }
    }
}

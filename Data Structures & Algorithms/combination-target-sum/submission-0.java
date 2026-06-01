class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,0,target,new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums,int ind,int target,List<Integer> temp)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(ind>=nums.length)
        return;
        if( target-nums[ind]>=0)
        {
            List<Integer> op1=new ArrayList<>(temp);
            op1.add(nums[ind]);
            dfs(nums,ind,target-nums[ind],op1);
        }
        dfs(nums,ind+1,target,temp);
    }
}

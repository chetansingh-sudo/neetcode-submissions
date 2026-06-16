class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0);
        return ans;
    }
    public void dfs(int[] nums,int ind)
    {
        if(ind==nums.length-1)
        {
            List<Integer> temp=Arrays.stream(nums).boxed().toList();
            if(!ans.contains(temp))
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<nums.length;i++)
        {
            swap(nums,i,ind);
            dfs(nums,ind+1);
            swap(nums,i,ind);

        }
    }
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }
}
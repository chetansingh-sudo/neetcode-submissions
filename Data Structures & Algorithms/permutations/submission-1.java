class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,0);
        return ans;
    }
    public void dfs(int[] nums,int ind)
    {
        if(ind==nums.length-1)
        {
            List<Integer> list = Arrays.stream(nums)
                           .boxed()
                           .collect(Collectors.toList());
            ans.add(new ArrayList<>(list));
            
            return;
        }
        for(int i=ind;i<nums.length;i++)
        {
            swap(nums,ind,i);
            
            dfs(nums,ind+1);
            swap(nums,ind,i);
        }
    }
}

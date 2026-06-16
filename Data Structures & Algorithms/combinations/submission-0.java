class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums=new int[n+1];
        for(int i=0;i<n;i++)
        {
            nums[i]=i+1;
        }
        dfs(nums,0,k,new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums,int ind,int size,List<Integer> temp)
    {
        if(ind<nums.length  && temp.size()==size)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(ind<nums.length){
            
            List<Integer> op1=new ArrayList<>(temp);
            op1.add(nums[ind]);
            dfs(nums,ind+1,size,op1);
            if(op1.size()!=0)
            op1.remove(op1.size()-1);
        
        dfs(nums,ind+1,size,temp);
        }
    }
}
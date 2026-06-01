class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
       
        return ans;
    }
    public void dfs(int[] arr,int ind,List<Integer> temp)
    {
        if(ind==arr.length)
        {
            
            ans.add(temp);
            return;
        }
         List<Integer> op1=new ArrayList<>(temp);
         op1.add(arr[ind]);
        List<Integer> op2=new ArrayList<>(temp);
        dfs(arr,ind+1,op1);
        dfs(arr,ind+1,op2);

    }
}

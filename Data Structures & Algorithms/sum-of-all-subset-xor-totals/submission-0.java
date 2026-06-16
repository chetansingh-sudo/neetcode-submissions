class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        int sum=0;
        for(int i=0;i<ans.size();i++)
        {
            List<Integer> temp=ans.get(i);
            int sum2=0;
            if(temp.size()==0)
            continue;
            else if(temp.size()==1)
            {
                sum+=temp.get(0);
            }
            else
            {
                for(int j=0;j<temp.size();j++)
                {
                    sum2^=temp.get(j);
                }
            }
            sum+=sum2;
        }
        return sum;
    }
    public void dfs(int[] nums,int ind,List<Integer> temp)
    {
        if(ind==nums.length)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        List<Integer> op1=new ArrayList<>(temp);
        op1.add(nums[ind]);
        dfs(nums,ind+1,op1);
        dfs(nums,ind+1,temp);
    }
}
class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("(",n-1,n);
        return ans;
    }
    public void dfs(String op,int open,int close)
    {
        if(open==0 && close==0)
        {
            ans.add(op);
            return;
        }
        if(open>0)
        {
            
            dfs(op+"(",open-1,close);
        }
        if(close>open)
        {
            dfs(op+")",open,close-1);
        }
    }
}
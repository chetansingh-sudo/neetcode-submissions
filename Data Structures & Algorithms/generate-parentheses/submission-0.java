class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("(",n-1,n);
        return ans;
    }
    public void dfs(String val,int open,int close)
    {
        if(open==0 && close==0)
        {
            ans.add(val);
            return;
        }
        if(open>0)
        {
            String val1=val+"(";
            dfs(val1,open-1,close);

        }
        if(close>open)
        {
            String val2=val+")";
            dfs(val2,open,close-1);
        }
    }
}

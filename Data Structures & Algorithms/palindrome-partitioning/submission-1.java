class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,new ArrayList<String>());
        return ans;
    }
    public boolean isPalindrome(String s)
    {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    public void dfs(String s,List<String> temp)
    {
        if(s.length()==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            String prefix=s.substring(0,i+1);
            String ros=s.substring(i+1);
            if(isPalindrome(prefix))
            {
                temp.add(prefix);
                dfs(ros,temp);
                if(temp.size()!=0)
                {
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}

class Solution {
    String[] phone={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        return new ArrayList<>();
        return dfs(digits);
    }
    public List<String> dfs(String digits)
    {
       if(digits.length()==0)
       {
        List<String> temp=new ArrayList<>();
        temp.add("");
        return temp;
       } 
       String val=phone[digits.charAt(0)-'0'];
       List<String> res=dfs(digits.substring(1));
       
      
       List<String> ans=new ArrayList<>();
        for(int j=0;j<res.size();j++)
            {
       for(int i=0;i<val.length();i++)
       {
           
                ans.add(val.charAt(i)+res.get(j));
            }
       }
       return ans;
    }
    
}

class Solution {
    String[] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> temp=new ArrayList<>();
        if(digits.length()==0 || digits.isEmpty())
        return temp;
        return dfs(digits);
    }
    public List<String> dfs(String s)
    {
        if(s.length()==0)
        {
            List<String> temp=new ArrayList<>();
            temp.add("");
            return temp;
        }
        char c=s.charAt(0);
        List<String> ans=dfs(s.substring(1));
        List<String> res=new ArrayList<>();
        String val=arr[c-'0'];
        for(char d:val.toCharArray())
        {
            for(int i=0;i<ans.size();i++)
            {
                res.add(d+""+ans.get(i));
            }
        }
        return res;
    }
}

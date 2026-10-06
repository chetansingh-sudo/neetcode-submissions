class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<s.length();)
        {
            int start=i;
            int lastIndex=s.lastIndexOf(s.charAt(start));
            for(int j=start;j<=lastIndex-1;j++)
            {
                int endIndex=s.lastIndexOf(s.charAt(j));
                if(endIndex>lastIndex)
                {
                    lastIndex=endIndex;
                }
            }
            ans.add(lastIndex-start+1);
            i=lastIndex+1;
        }
        return ans;
    }
}

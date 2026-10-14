class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char[] c=strs[i].toCharArray();
            Arrays.sort(c);
            if(hm.containsKey(String.valueOf(c)))
            {
                hm.get(String.valueOf(c)).add(strs[i]);
            }
            else
            {
                List<String> temp=new ArrayList<>(Arrays.asList(strs[i]));
                hm.put(String.valueOf(c),temp);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,List<String>> st:hm.entrySet())
        {
            ans.add(new ArrayList<>(st.getValue()));
        }
        return ans;
    }
}
